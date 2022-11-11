package com.Mytrust.MyTrustPortal.restController;

import com.Mytrust.MyTrustPortal.dto.*;
import com.Mytrust.MyTrustPortal.entity.*;
import com.Mytrust.MyTrustPortal.repo.AddSpocRepo;
import com.Mytrust.MyTrustPortal.repo.OrganazationRepo;
import com.Mytrust.MyTrustPortal.service.iface.OrganazationIface;

import com.Mytrust.MyTrustPortal.service.impl.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.xml.ws.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Blob;
import java.util.Base64;

@RestController
public class OrganazationregController {

    @Autowired
    OrganazationIface organazationIface;

    @Autowired
    OrganazationRepo organazationRepo;

    @Autowired
    AddSpocRepo addSpocRepo;

    @Autowired
    PdfService pdfService;



    @GetMapping(value = "/addorganazation")
    public ModelAndView addOrganazation(
                                        @RequestParam(defaultValue = "") String appid,
                                        @RequestParam(defaultValue = "") String action,
                                        Model model,
                                        HttpSession session
                                        ){
        try {
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
            model.addAttribute("username",userInfo.name);
            if(action.equals("privious")){
                OrganazationUser data = organazationRepo.getAppid(appid);
                model.addAttribute("privioussata",data);
                return  new ModelAndView("registerUser");
            }
            return new ModelAndView("registerUser");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/registeruser")
    public ModelAndView home(
            OrganazationRegDTO applicationUserDTO,
                             @RequestParam("organazationLogo") MultipartFile multipartFile,
                             HttpSession session,
                             Model model
    ) throws IOException {

        UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
        String suId = userInfo.applicationID;
        applicationUserDTO.setOrganizationsLogo(multipartFile.getBytes());
        OrganazationUser saveOrgData = organazationIface.addOrganazation(applicationUserDTO, suId);
                model.addAttribute("registerData",saveOrgData);
                session.setAttribute("registerdata",saveOrgData);
                session.setAttribute("appId",saveOrgData.getApplicationId());
                session.setAttribute("message","Data Saved Successfully");
                String appid =  saveOrgData.getApplicationId();
                return new ModelAndView("redirect:/boardofdir/" + appid);
    }

    //boardDir controller
    @PostMapping("/upload-file")
    public ModelAndView uploadFile(
            @RequestParam("taxLetter") MultipartFile taxfile,
            @RequestParam("incorporationLetter") MultipartFile incorpoarationfile,
            @RequestParam("additionalDoc") MultipartFile additionaldoc,
            @RequestParam("additionalDoc2") MultipartFile additionalDoc2,
            @RequestParam("additionalDoc3") MultipartFile additionalDoc3,

            HttpSession session
            ) throws IOException {

        try {

            Object appId =  session.getAttribute("appid");


        BoardOfDirEntity boardOfDir = organazationIface.addBoardOfDir(taxfile,incorpoarationfile,additionaldoc,additionalDoc2,additionalDoc3,String.valueOf(appId));
        String appid = boardOfDir.getApplicationId();
        session.setAttribute("appid",boardOfDir.getApplicationId());
        return new ModelAndView("redirect:/spoc/"+ appid);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/boardofdir/{appid}")
    public ModelAndView boardofDir(HttpSession session,@PathVariable("appid") String appid,Model model){
        try {
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
            model.addAttribute("username",userInfo.name);
          Object data =   session.getAttribute("registerdata");
            session.setAttribute("appid",appid);
            model.addAttribute("appid",appid);
            model.addAttribute("listdirector",organazationIface.getDirectoryList(appid));


            return new ModelAndView("BoardOfDir");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/addboarddir")
    public ModelAndView getBoardOfDirectory(HttpSession session){
        try {

            return new ModelAndView("AddBoardOfDir");

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }



    @PostMapping("/addboarddir")
    public ModelAndView addBoardOfDirectory(AddDirectorDTO addDirectorDTO, HttpSession session){
        try {
            Object appId =  session.getAttribute("appid");

            addDirectorDTO.setApplicationId(String.valueOf(appId));

            AddDirectorEntity addDirectorEntity =  organazationIface.addDirectorUser(addDirectorDTO);

          session.setAttribute("appid",addDirectorEntity.getApplication_id());
            return new ModelAndView("redirect:/boardofdir/"+appId);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }


    @GetMapping("/spoc/{appid}")
    public ModelAndView getSpoc(@PathVariable("appid") String appid, HttpSession session,Model model){
        try {
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
            model.addAttribute("username",userInfo.name);

            session.setAttribute("appid",appid);

//            model.addAttribute("spocuserlist",organazationIface.getAllSpocUser());
            model.addAttribute("spocuserlist",addSpocRepo.getSpocList(appid));


            model.addAttribute("appid",session.getAttribute("appid"));

            return new ModelAndView("Spoc");

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @GetMapping("/mytrust/spoc/addspocuser")
    public ModelAndView addSpoc( HttpSession session){
        try {
            return new ModelAndView("addSpoc");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/addspocuser")
    public ModelAndView addSpocUser(AddSpocUserDTO addSpocUserDTO, HttpSession session,Model model){
        try {
            Object appid = session.getAttribute("appid");
            int addSpocEntityCount =  addSpocRepo.getCountBySpocUser(String.valueOf(appid));
            if(addSpocEntityCount  > 2){
                session.setAttribute("message","limit exceeds...");
                return new ModelAndView("redirect:/api/mytrust/spoc/" + appid);
            }else {
                addSpocUserDTO.setApplicationId(String.valueOf(appid));
                AddSpocEntity addSpocEntity =   organazationIface.addSpocUser(addSpocUserDTO);
                session.setAttribute("appid",addSpocEntity.getApplicationId());
                return new ModelAndView("redirect:/spoc/" + appid);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


        @GetMapping("/pdf")
    public void showPdf() throws InterruptedException {
            System.out.println("test");
        pdfService.generatePdf("GOHHR");
    }

    @GetMapping("/consent/{appid}")
    public ModelAndView concent( @PathVariable("appid") String appid,
                                 HttpSession session,
                                 Model model
                                 ){
        try {
            UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
            model.addAttribute("username",userInfo.name);
             session.setAttribute("appid",appid);
            Object concentDataToShow =  session.getAttribute("registerdata");
            model.addAttribute("registerdata",concentDataToShow);
            model.addAttribute("appid",appid);

            pdfService.generatePdf(appid);

            return new ModelAndView("Concent");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/concent")
    public ResponseEntity<?> addConcent(
            HttpSession session,
            @RequestParam("file") MultipartFile multipartFile

    ){
        try {

            Object appid= session.getAttribute("appid");
            ConcentDto concentDto = new ConcentDto();
            concentDto.setConsentpdf(multipartFile.getBytes());
            concentDto.setApplication_id(String.valueOf(appid));


            ConcentEntity concentEntity =  organazationIface.addConcent(concentDto);

            return ResponseEntity.ok("file uploaded successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/concentdownload")
    public ModelAndView getConcentDownload(){
        return  new ModelAndView("concentRegister");
    }


    @GetMapping("/apphistory")
    public ModelAndView getApplicationHistory(Model model){

        try {

            model.addAttribute("applicationData",organazationIface.getAllApplicationList());

            return new ModelAndView("ApplicationHistory");

        }catch (Exception e){
            e.printStackTrace();

        }
        return null;
    }


    @GetMapping("/resumeapp")
    public ModelAndView resumeApplication(
            Model model){
        try {
            model.addAttribute("applicationPendingData",organazationIface.getAllPendingList());
            return  new ModelAndView("ResumeApplicationPage");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    @GetMapping("/resumeappopen/{appid}")
    public ModelAndView resumeAppRedirect(
            @PathVariable("appid") String appid,
            Model model
    ){

        model.addAttribute("applicationPendingData",organazationIface.getAllPendingList());


        String formStatus =   organazationRepo.getOrganazationStatus(appid);

        if(formStatus.equals("form1")){

            return new ModelAndView("redirect:/boardofdir/" + appid);
        }else if(formStatus.equals("form2")){
            return new ModelAndView("redirect:/spoc/"+ appid);

        }else if(formStatus.equals("form3")){
            return new ModelAndView("redirect:/boardofdir/"+appid);

        }else if(formStatus.equals("form4")) {
            return new ModelAndView("redirect:/spoc/" + appid);
        }

        return null;
    }


}
