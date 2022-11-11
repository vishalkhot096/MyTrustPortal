package com.Mytrust.MyTrustPortal.repo;

import com.Mytrust.MyTrustPortal.entity.OrganazationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganazationRepo extends JpaRepository<OrganazationUser,Integer> {


    @Query(value = "select * from onboarding_application  where application_id = ?1",nativeQuery =  true)
    OrganazationUser findByAppId(String appId);

    @Query(value = "select * from onboarding_application  where application_id = ?1",nativeQuery =  true)
    OrganazationUser getAppid(String id);

    @Query(value = "select * from onboarding_application  where status <>'Complete'",nativeQuery = true)
   List <OrganazationUser> getPendingList();

    @Query(value ="select status from onboarding_application  where application_id = ?1",nativeQuery = true)
    String getOrganazationStatus(String appid);



}
