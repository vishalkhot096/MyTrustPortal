package com.Mytrust.MyTrustPortal.repo;

import com.Mytrust.MyTrustPortal.entity.AddDirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddDirectorRepo extends JpaRepository<AddDirectorEntity,Integer> {

    @Query(value = "select * from director_add  where application_id = ?1",nativeQuery = true)
    List<AddDirectorEntity> getDirectoryList(String appid);
}
