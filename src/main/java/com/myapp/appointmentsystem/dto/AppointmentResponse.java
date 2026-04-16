package com.myapp.appointmentsystem.dto;

import java.time.LocalTime;
import java.time.LocalDate;


public class AppointmentResponse {

	private Long id;
	private LocalDate date;
	private LocalTime time;
	private String clientName;
	
	public AppointmentResponse ( Long id, LocalDate date, LocalTime time, String clientName) {
		this.id = id;
        this.date = date;
        this.time = time;
        this.clientName = clientName;
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

    public String getClientName() {
        return clientName;
    }
}
