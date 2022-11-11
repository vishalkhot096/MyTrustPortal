package com.Mytrust.MyTrustPortal.service.impl;

import com.Mytrust.MyTrustPortal.dto.*;
import com.Mytrust.MyTrustPortal.entity.*;
import com.Mytrust.MyTrustPortal.repo.*;
import com.Mytrust.MyTrustPortal.restController.UserInfo;
import com.Mytrust.MyTrustPortal.service.iface.OrganazationIface;
import com.Mytrust.MyTrustPortal.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class OrganazationImpl implements OrganazationIface {

    @Autowired
    OrganazationRepo organazationRepo;

    @Autowired
    BoardOfDirRepo boardRepo;

    @Autowired
    AddDirectorRepo addDirectorRepo;

    @Autowired
    AddSpocRepo addSpocRepo;

    @Autowired
    ConcentRepo concentRepo;



    public static String generateApplicationUid() {

        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 5;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println("Random String is: " + randomString);
        return sb.toString();
    }



    @Override
    public OrganazationUser addOrganazation(OrganazationRegDTO applicationUserDTO,String suId) {
        try {
            OrganazationUser organazationUser = new OrganazationUser();
            if (applicationUserDTO.getApplicationId() == ""  || organazationUser.getOrganazationLogo() != applicationUserDTO.getOrganizationsLogo()){
                String appId = generateApplicationUid();
                organazationUser.setName(applicationUserDTO.getName());
                organazationUser.setEmail(applicationUserDTO.getEmail());
                organazationUser.setMobileNo(applicationUserDTO.getMobileNo());
                organazationUser.setLandline(applicationUserDTO.getLandline());
                organazationUser.setPinCode(applicationUserDTO.getPinCode());
                organazationUser.setTaxNo(applicationUserDTO.getTaxNo());
                organazationUser.setAddress(applicationUserDTO.getAddress());
                organazationUser.setApplicationId(appId);
                organazationUser.setCountry(applicationUserDTO.getCountry());
                organazationUser.setCreatedAt(AppUtil.getDate());
                organazationUser.setStatus("form1");
                organazationUser.setSubscriberSuid(suId);
                organazationUser.setExpireDate(AppUtil.setExpiryDateAfterThirteyDays().toString());
                organazationUser.setOrganazationLogo(applicationUserDTO.getOrganizationsLogo());
                organazationRepo.save(organazationUser);
                return organazationUser;

            }
            else {      //update part
              OrganazationUser organazationUserUpdated = organazationRepo.getAppid(applicationUserDTO.getApplicationId());
                    if (organazationUserUpdated.getApplicationId().equals(applicationUserDTO.getApplicationId())){
                        organazationUser.setId(organazationUserUpdated.getId());
                        organazationUser.setName(applicationUserDTO.getName());
                        organazationUser.setEmail(applicationUserDTO.getEmail());
                        organazationUser.setMobileNo(applicationUserDTO.getMobileNo());
                        organazationUser.setLandline(applicationUserDTO.getLandline());
                        organazationUser.setPinCode(applicationUserDTO.getPinCode());
                        organazationUser.setTaxNo(applicationUserDTO.getTaxNo());
                        organazationUser.setAddress(applicationUserDTO.getAddress());
                        organazationUser.setApplicationId(organazationUserUpdated.getApplicationId());
                        organazationUser.setCountry(applicationUserDTO.getCountry());
                        organazationUser.setCreatedAt(AppUtil.getDate());
                        organazationUser.setCreatedAt(AppUtil.getDate());
                        organazationUser.setStatus("form1");
                        organazationUser.setSubscriberSuid(suId);
                        organazationUser.setExpireDate(AppUtil.setExpiryDateAfterThirteyDays().toString());
                        organazationUser.setOrganazationLogo(applicationUserDTO.getOrganizationsLogo());

                        organazationRepo.save(organazationUser);
                        return organazationUser;
                    }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BoardOfDirEntity addBoardOfDir(MultipartFile taxFile,MultipartFile incoroporationFile,MultipartFile additioanldoc,
                                          MultipartFile additionalDoc2,MultipartFile additionalDoc3,String appId ) {

        try {
         OrganazationUser organazationUser  = organazationRepo.findByAppId(appId);

            if(organazationUser.getApplicationId().equals(String.valueOf(appId))){

                BoardOfDirEntity boardOfDir = new BoardOfDirEntity();
                boardOfDir.setApplicationId(appId);
                boardOfDir.setTexLetter(taxFile.getBytes());
                boardOfDir.setIncorporationLetter(incoroporationFile.getBytes());
                boardOfDir.setAdditionalDoc(additioanldoc.getBytes());
                boardOfDir.setAdditionalDoc2(additionalDoc2.getBytes());
                boardOfDir.setAdditionalDoc3(additionalDoc3.getBytes());
                boardOfDir.setTaxFileName(taxFile.getOriginalFilename());
                boardOfDir.setIncorporationFileName(incoroporationFile.getOriginalFilename());
                boardOfDir.setAdditionalDocFileName(additioanldoc.getOriginalFilename());
                boardOfDir.setAdditionalDocFileName2(additionalDoc2.getOriginalFilename());
                boardOfDir.setAdditionalDocFileName3(additionalDoc3.getOriginalFilename());

                organazationUser.setStatus("form2");

                boardRepo.save(boardOfDir);
                return boardOfDir;

            }else {
                return  null;
            }




        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AddDirectorEntity addDirectorUser(AddDirectorDTO addDirectorDTO) {
        try {

            OrganazationUser organazationUser  = organazationRepo.findByAppId(addDirectorDTO.getApplicationId());

            if(organazationUser.getApplicationId().equals(addDirectorDTO.getApplicationId())){

                AddDirectorEntity addDirectorEntity = new AddDirectorEntity();
                addDirectorEntity.setApplication_id(addDirectorDTO.getApplicationId());
                addDirectorEntity.setDirector_name(addDirectorDTO.getDirectorName());
                addDirectorEntity.setOffice_email(addDirectorDTO.getOfficeEmail());
                addDirectorEntity.setMytrust_email(addDirectorDTO.getMytrustEmail());
                addDirectorEntity.setMobile_number(addDirectorDTO.getMobileNumber());
                organazationUser.setStatus("form3");

               addDirectorRepo.save(addDirectorEntity);
                return addDirectorEntity;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public AddSpocEntity addSpocUser(AddSpocUserDTO addSpocUserDTO) {
        try {
            OrganazationUser organazationUser  = organazationRepo.findByAppId(addSpocUserDTO.getApplicationId());

            if(organazationUser.getApplicationId().equals(addSpocUserDTO.getApplicationId())){
                AddSpocEntity addSpocEntity = new AddSpocEntity();
                addSpocEntity.setApplicationId(addSpocUserDTO.getApplicationId());
                addSpocEntity.setSpocName(addSpocUserDTO.getSpocName());
                addSpocEntity.setSpocOfficeEmail(addSpocUserDTO.getSpocOfficeEmail());
                addSpocEntity.setSpocMyTrustEmail(addSpocUserDTO.getSpocMyTrustEmail());
                addSpocEntity.setSpocMobileNumber(addSpocUserDTO.getSpocMobileNumber());
                organazationUser.setStatus("form4");

                addSpocRepo.save(addSpocEntity);
                    return addSpocEntity;

            }

        }catch (Exception e){
            e.printStackTrace();
        }




        return null;
    }

    @Override
    public List<AddDirectorEntity> getAllDirector() {
      return    addDirectorRepo.findAll();

    }

    @Override
    public List<AddSpocEntity> getAllSpocUser() {
        return addSpocRepo.findAll();
    }

    @Override
    public List<OrganazationUser> getAllApplicationList() {
        return organazationRepo.findAll();
    }

    @Override
    public List<OrganazationUser> getAllPendingList() {
        return organazationRepo.getPendingList();
    }




    @Override
    public ConcentEntity addConcent(ConcentDto concentDto) {

        try {
            OrganazationUser organazationUser  = organazationRepo.findByAppId(concentDto.getApplication_id());

            if(organazationUser.getApplicationId().equals(concentDto.getApplication_id())){
                OrganazationUser organazation = new OrganazationUser();
                ConcentEntity concentEntity = new ConcentEntity();
                concentEntity.setApplication_id(concentDto.getApplication_id());
                concentEntity.setConsentPdf(concentDto.getConsentpdf());
                organazationUser.setStatus("Complete");
                organazationRepo.save(organazationUser);
                concentRepo.save(concentEntity);




                  return concentEntity;
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<AddDirectorEntity> getDirectoryList(String appid) {
        return addDirectorRepo.getDirectoryList(appid);
    }


    @GetMapping("/consent-form/download")
    public void downloadConsentForm(HttpServletResponse response) throws IOException {
        String fileName = "D:\\vishal_khot\\Java\\MyTrust\\MyTrustPortal-new\\src\\main\\resources\\static\\data\\out.pdf";
        File file = new File(fileName);
        if (file.exists()) {

            //get the mimetype
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                //unknown mimetype so set the mimetype to application/octet-stream
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);

            /**
             * In a regular HTTP response, the Content-Disposition response header is a
             * header indicating if the content is expected to be displayed inline in the
             * browser, that is, as a Web page or as part of a Web page, or as an
             * attachment, that is downloaded and saved locally.
             *
             */

            /**
             * Here we have mentioned it to show inline
             */
//            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));

            //Here we have mentioned it to show as attachment
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));

            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }


}
