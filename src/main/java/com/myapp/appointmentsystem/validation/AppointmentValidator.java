package com.myapp.appointmentsystem.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.myapp.appointmentsystem.model.Appointment;
import com.myapp.appointmentsystem.repository.AppointmentRepository;

//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppointmentValidator {

	public static void validateAppointmentCreation (Appointment appointment, AppointmentRepository repository) {
		
		//duplcado:
		
		if (repository.existsByDateAndTime(appointment.getDate(), appointment.getTime())) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,
					"Appointment already exists for this date and time");
		}
		
		//pasado:
		
		LocalDateTime appointmentDateTime = LocalDateTime.of(appointment.getDate(), appointment.getTime());
		
		if (appointmentDateTime.isBefore(LocalDateTime.now())) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,"Cannot create appointment in the past.");
		}
		
		//horario invalido:
		
		LocalTime start = LocalTime.of(9, 0);
		LocalTime end = LocalTime.of(18,0);
		
		if (appointment.getTime().isBefore(start) || appointment.getTime().isAfter(end)) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,
					"Appointment must be between 09:00 and 18:00");		
		}
		
		
	}
}
