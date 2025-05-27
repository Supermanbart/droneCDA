package com.drone.drone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drone.drone.entity.FlightController;
import com.drone.drone.service.FlightControllerService;

@RestController
@RequestMapping("/flightController")
public class FlightControllerController {

	@Autowired
	private FlightControllerService flightControllerService;
	
	@GetMapping("")
	public ResponseEntity<List<FlightController>> getAllFlightControllers(){
		return ResponseEntity.ok(flightControllerService.getAllFlightControllers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FlightController> getFlightControllerById(@PathVariable Long id) {
		var fcResult = flightControllerService.getFlightControllerById(id);
		if (fcResult.isEmpty())
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(fcResult.get());
	}
	
	@PostMapping("/add")
	public ResponseEntity<FlightController> saveFlightController(@RequestBody FlightController fc) {
		return ResponseEntity.ok(flightControllerService.saveFlightController(fc));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateFlightController(@PathVariable Long id, @RequestBody FlightController fc){
		var newFc = flightControllerService.updateFlightControllerById(id, fc);
		if (newFc == null) {
			return ResponseEntity.badRequest().body("Id not found");
		}
		else {
			return ResponseEntity.ok("Le Flight Controller a été mis à jour");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFlightController(@PathVariable Long id){
		if (!flightControllerService.deleteFlightControllerById(id))
		{
			return ResponseEntity.badRequest().body("Impossible to delete flightController with id: " + id + ", id not found");
		}
		return ResponseEntity.ok("FlightController deleted");
	}
	
}
