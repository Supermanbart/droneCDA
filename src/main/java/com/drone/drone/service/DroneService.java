package com.drone.drone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drone.drone.entity.Drone;
import com.drone.drone.repository.IDroneRepository;

@Service
public class DroneService {

	@Autowired
	private IDroneRepository droneRepository;
	
	public Drone saveDrone(Drone drone) {
		return droneRepository.save(drone);
	}
	
	public Optional<Drone> getDroneById(Long id){
		return droneRepository.findById(id);
	}
	
	public List<Drone> getAllDrones(){
		return droneRepository.findAll();
	}
	
	public void deleteDroneById(Long id) {
		droneRepository.deleteById(id);
	}
}
