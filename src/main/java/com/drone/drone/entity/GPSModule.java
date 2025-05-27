package com.drone.drone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="GPSMODULE")
@Data
public class GPSModule {

	@Id
	@Column(name="IDGPSMODULE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idGPSModule;
	
	@Column(name="LATITUDE")
	private String latitude; // ex: 41°24'12.2"N
	
	@Column(name="LONGITUDE")
	private String longitude; // ex: 2°10'26.5"E
	
	@Column(name="ALTITUDE")
	private int altitude; // hauteur au dessus de la mer (en m)
	
	@ManyToOne
	@JoinColumn(name = "FLIGHTCONTROLLERID")
	private FlightController flightController;
}
