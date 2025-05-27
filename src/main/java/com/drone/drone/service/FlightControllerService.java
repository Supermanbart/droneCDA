package com.drone.drone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drone.drone.entity.FlightController;
import com.drone.drone.repository.IFlightControllerRepository;

@Service
public class FlightControllerService {

	@Autowired
	private IFlightControllerRepository flightControllerRepository;
	
	public FlightController saveFlightController(FlightController flightController) {
		return flightControllerRepository.save(flightController);
	}
	
	public Optional<FlightController> getFlightControllerById(Long id) {
		return flightControllerRepository.findById(id);
	}
	
	public List<FlightController> getAllFlightControllers() {
		return flightControllerRepository.findAll();
	}
	
	public FlightController updateFlightControllerById(Long id, FlightController flightController){
		Optional<FlightController> newFcOptional = flightControllerRepository.findById(id);
		if (newFcOptional.isEmpty()) {
			return null;
		}
		FlightController newFc = newFcOptional.get();
		newFc.setAltitudeCible(flightController.getAltitudeCible());
		newFc.setPositionCible(flightController.getPositionCible());
		return flightControllerRepository.save(newFc);
	}
	
	public boolean deleteFlightControllerById(Long id) {
		if (flightControllerRepository.findById(id).isEmpty())
			return false;
		flightControllerRepository.deleteById(id);
		return true;
	}
}
