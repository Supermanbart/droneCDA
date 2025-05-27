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

import com.drone.drone.entity.Camera;
import com.drone.drone.service.CameraService;

@RestController
@RequestMapping("/camera")
public class CameraController {

	@Autowired
	private CameraService cameraService;
	
	@GetMapping("")
	public ResponseEntity<List<Camera>> getAllCameras() {
		return ResponseEntity.ok(cameraService.getAllCameras());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Camera> getCameraById(@PathVariable Long id) {
		var camera = cameraService.getCameraById(id);
		if (camera.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(camera.get());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Camera> saveCamera(@RequestBody Camera camera) {
		return ResponseEntity.ok(cameraService.saveCamera(camera));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCameraById(@PathVariable Long id) {
		var camera = cameraService.getCameraById(id);
		if (camera.isEmpty()) {
			return ResponseEntity.badRequest().body("Can't delete camera, id not found");
		}
		cameraService.deleteCameraById(id);
		return ResponseEntity.ok("Camera successfully deleted !");
	}
}
