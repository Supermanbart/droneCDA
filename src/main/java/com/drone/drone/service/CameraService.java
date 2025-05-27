package com.drone.drone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drone.drone.entity.Camera;
import com.drone.drone.repository.ICameraRepository;

@Service
public class CameraService {

	@Autowired
	private ICameraRepository cameraRepository;
	
	public List<Camera> getAllCameras(){
		return cameraRepository.findAll();
	}
	
	public Optional<Camera> getCameraById(Long id) {
		return cameraRepository.findById(id);
	}
	
	public Camera saveCamera(Camera camera) {
		return cameraRepository.save(camera);
	}
	
	public void deleteCameraById(Long id) {
		cameraRepository.deleteById(id);
	}
}
