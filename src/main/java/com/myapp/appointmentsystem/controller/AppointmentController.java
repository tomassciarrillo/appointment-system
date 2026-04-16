package com.myapp.appointmentsystem.controller;

import com.myapp.appointmentsystem.model.Appointment;
import com.myapp.appointmentsystem.service.AppointmentService;
import com.myapp.appointmentsystem.dto.AppointmentRequest;
import com.myapp.appointmentsystem.dto.AppointmentResponse;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	private final AppointmentService service;
	
	public AppointmentController (AppointmentService service) {
		this.service=service;
	}
	
	
	@GetMapping
	public List<AppointmentResponse> getAppointments(
		@RequestParam(required=false) Long clientId,
		@RequestParam(required=false) LocalDate date
		)
		{	
		return service.getAppointments(clientId, date);
	}
	
	@GetMapping("/available")
	public List<LocalTime> getAvailableSlots(@RequestParam LocalDate date) {
		return service.getAvailableSlots(date);
	}
	
	@PostMapping
	public Appointment createAppointment(@RequestBody AppointmentRequest request) {
		return service.createAppointment(request);
	}
	
	@DeleteMapping("/{id}")
	public void cancelAppointment(@PathVariable Long id) {
		service.cancelAppointment(id);
	}
	
	
	
}
