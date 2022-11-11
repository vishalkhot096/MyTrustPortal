package com.Mytrust.MyTrustPortal.repo;

import com.Mytrust.MyTrustPortal.entity.AddSpocEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddSpocRepo extends JpaRepository<AddSpocEntity,Integer> {

    @Query(value = "select count(*) from spoc_user where application_id = ?1",nativeQuery =  true)
    int getCountBySpocUser(String appId);

    @Query(value = "select * from spoc_user where application_id = ?1",nativeQuery = true)
    List<AddSpocEntity> getSpocList(String appId);
}
