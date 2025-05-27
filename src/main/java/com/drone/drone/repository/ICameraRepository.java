package com.drone.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drone.drone.entity.Camera;

@Repository
public interface ICameraRepository extends JpaRepository<Camera, Long>{

}
