package com.drone.drone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drone.drone.entity.GPSModule;
import com.drone.drone.service.GPSModuleService;

@RestController
@RequestMapping("/gpsModule")
public class GPSModuleController {

	@Autowired
	private GPSModuleService gpsModuleService;
	
	@GetMapping("")
	public ResponseEntity<List<GPSModule>> getAllGPSModules() {
		return ResponseEntity.ok(gpsModuleService.getAllGPSModules());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GPSModule> getGPSModuleById(@PathVariable Long id) {
		var gpsModule = gpsModuleService.getGPSModuleById(id);
		if (gpsModule.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(gpsModule.get());
	}
	
	@PostMapping("/add")
	public ResponseEntity<GPSModule> saveGPSModule(@RequestBody GPSModule gpsModule) {
		return ResponseEntity.ok(gpsModuleService.saveGPSModule(gpsModule));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGPSModuleById(@PathVariable Long id) {
		var gpsModule = gpsModuleService.getGPSModuleById(id);
		if (gpsModule.isEmpty()) {
			return ResponseEntity.badRequest().body("Can't delete gpsModule, id not found");
		}
		gpsModuleService.deleteGPSModuleById(id);
		return ResponseEntity.ok("GPSModule successfully deleted !");
	}
}
