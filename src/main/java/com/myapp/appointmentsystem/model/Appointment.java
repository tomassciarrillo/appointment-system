package com.myapp.appointmentsystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class Appointment {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	private LocalTime time;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_id")
	private Client client;
	
	public Appointment() {}
	
	public Appointment (LocalDate date, LocalTime time, Client client) {
		this.date=date;
		this.time=time;
		this.client=client;
	}
	
	public Long getId() {
		return id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public LocalTime getTime() {
		return time;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient (Client client) {
		this.client=client;
	}
	
	public void setDate(LocalDate date) {
		this.date=date;
	}
	
	public void setTime(LocalTime time) {
		this.time=time;
	}
}
