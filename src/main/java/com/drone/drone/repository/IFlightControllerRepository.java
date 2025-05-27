package com.drone.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drone.drone.entity.FlightController;

@Repository
public interface IFlightControllerRepository extends JpaRepository<FlightController, Long>{

}
