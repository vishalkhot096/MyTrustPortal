package com.Mytrust.MyTrustPortal.service;

import com.Mytrust.MyTrustPortal.model.JwkNew;
import com.Mytrust.MyTrustPortal.restController.UserInfo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.*;
import java.util.Base64;

@Service
public class RestServiceImplementation implements RestService {


	@Value("${idp.clientId}")
	private String clientId;

	@Value("${idp.redirectUri}")
	private String redirectUri;

	@Value("${idp.scope}")
	private String scope;

	@Value("${idp.tokenUrl}")
	private String tokenUrl;

	@Value("${jwt.clientassertiontype}")
	private String clientassertiontype;

	@Value("${idp.idpUrl}")
	private String idpUrl;

	@Value("${idp.idpjwkSetURL}")
	private String idpjwkSetURL;

	@Value("${idp.loginField}")
	private String loginField;

	@Value("${idp.aud}")
	private String Aud;

	@Value("${privateKey}")
	private String privateKey;

	@Autowired
	 RestTemplate restTemplate;

	private static final long VALIDITY_IN_MILLISECONDS = 24 * 60 * 60 * 1000;// 24 hrs

	private PrivateKey getPrivateKey() {
		try {
			String rsaPrivateKey = privateKey;
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(rsaPrivateKey));
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PrivateKey _privateKey = kf.generatePrivate(keySpec);
			return _privateKey;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}


	public String generateJWTWithRsa(Boolean isAuthorizedUrl, String state, String nonce) {
		try {
			// Generate Token
			String id = UUID.randomUUID().toString();

			Map<String, Object> claims = new HashMap<>( );
			claims.put("iss", clientId);
			claims.put("sub", clientId);
			claims.put("iat", new Date(System.currentTimeMillis()));

			if(isAuthorizedUrl == true) {
				claims.put("redirect_uri",redirectUri);
				claims.put("aud", Aud);
				claims.put("scope",scope);
				claims.put("state",state);
				claims.put("nonce",nonce);
			}else {
				claims.put("aud", tokenUrl);
			}

			PrivateKey privateKey = getPrivateKey();
			String signedToken = generateJwtToken(privateKey, VALIDITY_IN_MILLISECONDS,id, claims);
			return signedToken;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}


	public String generateJwtToken(PrivateKey privateKey, long expirationInMillis, String id, Map<String, Object> claims) {
		try {
			JwtBuilder builder = Jwts.builder()
					.setId(id)
					.setClaims(claims)
					.setHeaderParam("typ", "JWT")
					.setNotBefore(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis()))
					.signWith(SignatureAlgorithm.RS256, privateKey);

			if (expirationInMillis >= 0) {
				long expMillis = System.currentTimeMillis() + expirationInMillis;
				Date exp = new Date(expMillis);
				builder.setExpiration(exp);
			}

			String token = builder.compact();
			return token;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String generateApplicationUid() {
		UUID ouid = UUID.randomUUID();
		System.out.println("random uid ::" + ouid);
		return ouid.toString();
	}

	@Override
	public UserInfo getUserInfo(String code, HttpServletRequest request) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
			MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
			map.add("grant_type", "authorization_code");
			map.add("client_id", clientId);
			map.add("client_assertion_type",clientassertiontype);
			map.add("redirect_uri", redirectUri);
			map.add("code", code);
			map.add("client_assertion", generateJWTWithRsa(false, null, null));

			HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
			ResponseEntity<String> response = restTemplate.exchange(this.tokenUrl, HttpMethod.POST, entity,
					String.class);
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root = mapper.readTree(response.getBody());
				JsonNode idToken = root.path("id_token");

				String token = idToken.asText();
				if (idToken.asText() != null) {
					try {
						DecodedJWT decodedIdToken = JWT.decode(token);
						// Validation of nonce
						String tokennonce =decodedIdToken.getClaim("nonce").asString();
						String nonce=request.getSession().getValue("nonce").toString();
						if(!tokennonce.equals(nonce) ) {

							throw new RuntimeException("Nonce not match!");
						}

						ResponseEntity<String> restResponse = restTemplate.getForEntity(idpjwkSetURL, String.class);
						/*
						We can also cache this jwksurl response, and reuse for future calls
						 */
						JSONObject jwkUrlResponse = new JSONObject(restResponse.getBody());
						JSONArray arrKeys = jwkUrlResponse.getJSONArray("keys");
						JwkNew jwkNew = new JwkNew();
						for (int i = 0; i < arrKeys.length(); i++) {
							String kid = arrKeys.getJSONObject(i).getString("kid");
							if (kid.equals(decodedIdToken.getKeyId())) {
								jwkNew.setAlgorithm(arrKeys.getJSONObject(i).getString("alg"));
								jwkNew.setE(arrKeys.getJSONObject(i).getString("e"));
								jwkNew.setId(arrKeys.getJSONObject(i).getString("kid"));
								jwkNew.setN(arrKeys.getJSONObject(i).getString("n"));
								jwkNew.setType(arrKeys.getJSONObject(i).getString("kty"));
								jwkNew.setUsage(arrKeys.getJSONObject(i).getString("use"));
							}
						}

//						PublicKey pubkey = jwkNew.getPublicKey();
//						System.out.println("pubkey ::" + pubkey);
//						Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwkNew.getPublicKey(), null);
//						algorithm.verify(decodedIdToken);
//
//						if (decodedIdToken.getExpiresAt().before(Calendar.getInstance().getTime())) {
//							throw new RuntimeException("Expired token!");
//						}

						Claim claim = decodedIdToken.getClaim("daes_claims");
						UserInfo userInfo = claim.as(UserInfo.class);
						userInfo.setIdToken(token);
						String Application_id = generateApplicationUid();
						userInfo.setApplicationID(Application_id);


						return userInfo;
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				} else {
					System.out.println("Login failed. Access Token not obtained.");
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public byte[] base64UrlDecodeToBytes(String input) {
		org.apache.tomcat.util.codec.binary.Base64 decoder = new org.apache.tomcat.util.codec.binary.Base64(-1, null,
				true);
		byte[] decodedBytes = decoder.decode(input);

		return decodedBytes;
	}

	public String getClientId() {
		return clientId;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public String getScope() {
		return scope;
	}

	public String getTokenUrl() {
		return tokenUrl;
	}


	public String getIdpUrl() {
		return idpUrl;
	}

	public String getLoginField() {
		return loginField;
	}


}
