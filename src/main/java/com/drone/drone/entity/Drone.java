package com.drone.drone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Drone")
@Data
public class Drone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDDrone")
	private Long idDrone;
	
	@Column(name="MODELE")
	private String modele;
	
	@Column(name="POIDS")
	private int poids; // (en g)
	
	@Column(name="PORTEEMAXIMALE")
	private int porteeMaximale; // Distance maximale de connexion (en m)
	
	@OneToOne
	@JoinColumn(name = "CAMERAID")
	private Camera camera;
	
	@OneToOne
	@JoinColumn(name = "GPSMODULEID")
	private GPSModule gpsModule;
	
	@OneToOne
	@JoinColumn(name = "FLIGHTCONTROLLERID")
	private FlightController flightController;
}
