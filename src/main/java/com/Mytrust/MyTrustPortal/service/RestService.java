package com.Mytrust.MyTrustPortal.service;

import com.Mytrust.MyTrustPortal.restController.UserInfo;

import javax.servlet.http.HttpServletRequest;

public interface RestService {

    UserInfo getUserInfo(String code, HttpServletRequest request);
    String generateJWTWithRsa(Boolean isAuthorizedUrl, String state, String nonce);




}
