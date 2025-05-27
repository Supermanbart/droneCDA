package com.drone.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drone.drone.entity.GPSModule;

@Repository
public interface IGPSModuleRepository extends JpaRepository<GPSModule, Long>{

}
