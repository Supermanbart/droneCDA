package com.drone.drone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drone.drone.entity.GPSModule;
import com.drone.drone.repository.IGPSModuleRepository;

@Service
public class GPSModuleService {

	@Autowired
	private IGPSModuleRepository gpsModuleRepository;
	
	public List<GPSModule> getAllGPSModules(){
		return gpsModuleRepository.findAll();
	}
	
	public Optional<GPSModule> getGPSModuleById(Long id) {
		return gpsModuleRepository.findById(id);
	}
	
	public GPSModule saveGPSModule(GPSModule gpsModule) {
		return gpsModuleRepository.save(gpsModule);
	}
	
	public void deleteGPSModuleById(Long id) {
		gpsModuleRepository.deleteById(id);
	}
}
