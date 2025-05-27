package com.drone.drone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.drone.drone.entity.Drone;
import com.drone.drone.service.DroneService;

@Controller
public class ThymeLeafController {

	@Autowired
	DroneService droneService;
	
	@GetMapping("/list")
	public String showDroneList(Model model) {
		List<Drone> drones = droneService.getAllDrones();
		model.addAttribute("drones", drones);
		return "droneList";
	}
	
	@GetMapping("/add")
	public String showAddDroneForm(Model model) {
		model.addAttribute("drone", new Drone());
		return "addEditDrone";
	}
	
	@GetMapping("/edit/{id}")
	public String showEditDroneForm(@PathVariable Long id,Model model) {
		Drone drone = droneService.getDroneById(id).get();
		model.addAttribute("drone", drone);
		return "addEditDrone";
	}
	
	@PostMapping("/save")
	public String savePerson(@ModelAttribute Drone drone) {
		droneService.saveDrone(drone);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePerson(@PathVariable Long id) {
		droneService.deleteDroneById(id);
		return "redirect:/list";
	}
}
