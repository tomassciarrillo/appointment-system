package com.myapp.appointmentsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Client {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String email;
	
	public Client() {}
	
	public Client (String name, String email) {
		this.name=name;
		this.email=email;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
} 