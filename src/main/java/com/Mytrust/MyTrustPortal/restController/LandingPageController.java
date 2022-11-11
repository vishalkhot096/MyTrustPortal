package com.Mytrust.MyTrustPortal.restController;

import com.Mytrust.MyTrustPortal.service.RestService;
import com.Mytrust.MyTrustPortal.service.iface.OrganazationIface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class LandingPageController {
    private static final java.util.UUID UUID = null;

    @Value("${idp.idpUrl}")
    private String idp;

    @Value("${idp.logoutUrl}")
    private String logoutUrl;

    @Value("${idp.signUrl}")
    private String signingUrl;

    @Value("${idp.clientId}")
    private String clientId;

    @Value("${idp.redirectUri}")
    private String redirectUri;

    @Value("${idp.scope}")
    private String scope;


    @Autowired
    RestService restService;

    @Autowired
    OrganazationIface organazationIface;

    @GetMapping(value = "/home")
    public ModelAndView getLandingPage(Model model , HttpSession session) throws Exception{
        try {
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

            if (userInfo != null)
                return new ModelAndView("redirect:/dashboard");
            String state= UUID.randomUUID().toString();
            String nonce = UUID.randomUUID().toString();
            String idpUrl =idp+"client_id="+clientId+"&redirect_uri="+redirectUri+"&response_type=code"+"&scope="+scope+"&state="+state+"&nonce="+nonce+"&request="+restService.generateJWTWithRsa(true, state, nonce);
            model.addAttribute("idpUrl", idpUrl);
            session.setAttribute("state", state);
            session.setAttribute("nonce", nonce);
            return new ModelAndView("LandingPage2");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @GetMapping(value = "/mytrust/dashboard")
    public ModelAndView getmytrustPage(Model model,HttpSession session) throws Exception{
        try {

            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

//            session.setAttribute("userName",userInfo.name);
            model.addAttribute("username",userInfo.name);
            Object state= session.getAttribute("state");
            if (userInfo == null)
                return new ModelAndView("redirect:/home");

            model.addAttribute("userInfo", userInfo);
            return new ModelAndView("MyTrust");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/mytrust")
    public ModelAndView callback(@RequestParam(name = "code") Optional<String> code, @RequestParam(name = "state") Optional<String> state, @RequestParam(name = "error") Optional<String> error, Model model, HttpServletRequest request, HttpSession session)
    {
        try
        {

            if (!(code ==null))
            {
                //Validation of State
                String Originalstate= session.getAttribute("state").toString();;
                if(!Originalstate.equals(state.get()) ) {
                    model.addAttribute("error","State not match!");
                    return new ModelAndView("errorpage");
                }
                UserInfo userInfo = restService.getUserInfo(code.get(),request);
                request.getSession().setAttribute("userInfo", userInfo);
                return new ModelAndView("redirect:/mytrust/dashboard");
            }
            if (!(error == null))
            {
                model.addAttribute("error",error.get());
                return new ModelAndView("errorpage");
            }
        }
        catch (Exception e)
        {
            System.out.println("exceptioon ::" + e);
            model.addAttribute("error",e.getMessage());
            return new ModelAndView("errorpage");
        }
            return null;
    }


    @GetMapping(value = "/organazation")
    public ModelAndView getOrganazationPage(Model model , HttpSession session) throws Exception{
        try {
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
            model.addAttribute("username",userInfo.name);
            Object state= session.getAttribute("state");
            if (userInfo == null)
                return new ModelAndView("redirect:/home");
            model.addAttribute("userInfo", userInfo);
            session.setAttribute("userInfo",userInfo);
            return new ModelAndView("Organization");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @GetMapping("/basepage")
    public String getBasePage(){
        return "registerUser";
    }

}
