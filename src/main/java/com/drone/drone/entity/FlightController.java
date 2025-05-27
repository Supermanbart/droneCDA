package com.drone.drone.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="FLIGHTCONTROLLER")
@Data
public class FlightController {

	@Id
	@Column(name="IDFLIGHTCONTROLLER")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFlightController;
	
	@Column(name="ALTITUDECIBLE")
	private int altitudeCible;
	
	@OneToMany(mappedBy = "flightController")
	private List<GPSModule> positionCible;
}
