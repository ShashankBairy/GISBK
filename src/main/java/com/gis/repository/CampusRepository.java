package com.gis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gis.entity.CampusEntity;

@Repository
public interface CampusRepository extends JpaRepository<CampusEntity, Integer> {

}
