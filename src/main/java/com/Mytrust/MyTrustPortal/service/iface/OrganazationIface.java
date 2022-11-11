package com.Mytrust.MyTrustPortal.service.iface;

import com.Mytrust.MyTrustPortal.dto.*;
import com.Mytrust.MyTrustPortal.entity.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrganazationIface {

    OrganazationUser addOrganazation(OrganazationRegDTO applicationUserDTO, String suId);

    BoardOfDirEntity addBoardOfDir(MultipartFile taxFile,MultipartFile incoroporationFile,MultipartFile additioanldoc,
    MultipartFile additionalDoc2,MultipartFile additionalDoc3,String appId);

    AddDirectorEntity addDirectorUser(AddDirectorDTO addDirectorDTO);

    AddSpocEntity addSpocUser(AddSpocUserDTO addSpocUserDTO);

    List<AddDirectorEntity> getAllDirector();

    List<AddSpocEntity> getAllSpocUser();

    List<OrganazationUser> getAllApplicationList();

List<OrganazationUser> getAllPendingList();


    ConcentEntity addConcent(ConcentDto concentDto);

    List<AddDirectorEntity> getDirectoryList(String appid);


}
