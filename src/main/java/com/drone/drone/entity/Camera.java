package com.drone.drone.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="CAMERA")
@Data
public class Camera {

	@Id
	@Column(name="IDCAMERA")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCamera;
	
	@Column(name="RESOLUTION")
	private String resolution;
	
	@Column(name="ZOOM")
	private float zoom;
}
