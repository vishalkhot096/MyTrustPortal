package com.Mytrust.MyTrustPortal.repo;

import com.Mytrust.MyTrustPortal.entity.BoardOfDirEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardOfDirRepo extends JpaRepository<BoardOfDirEntity,Integer>{



}
