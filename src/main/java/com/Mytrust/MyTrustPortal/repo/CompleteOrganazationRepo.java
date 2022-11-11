package com.Mytrust.MyTrustPortal.repo;

import com.Mytrust.MyTrustPortal.entity.CompleteOrganazationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompleteOrganazationRepo extends JpaRepository<CompleteOrganazationDetails,String> {

    @Query(value = "select * from complete_organazations_details where application_id = ?1",nativeQuery = true)
    CompleteOrganazationDetails getCompleteOrganazationDetailsByAppId(String appID);

    @Query(value = "select * from complete_organazations_details where application_id = ?1",nativeQuery = true)
    List<CompleteOrganazationDetails> getBoardOfDirectoryList(String appId);
}
