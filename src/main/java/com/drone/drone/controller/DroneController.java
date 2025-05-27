package com.drone.drone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drone.drone.entity.Drone;
import com.drone.drone.service.DroneService;

@RestController
@RequestMapping("/drone")
public class DroneController {

	@Autowired
	private DroneService droneService;
	
	@PostMapping("/add")
	public ResponseEntity<Drone> saveDrone(@RequestBody Drone drone){
		Drone savedDrone = droneService.saveDrone(drone);
		return ResponseEntity.ok(savedDrone);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Drone>> getAllDrones(){
		return ResponseEntity.ok(droneService.getAllDrones());
	}
}
