package com.myapp.appointmentsystem.service;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;

import com.myapp.appointmentsystem.model.Appointment;
import com.myapp.appointmentsystem.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import com.myapp.appointmentsystem.dto.AppointmentRequest;
import com.myapp.appointmentsystem.dto.AppointmentResponse;
import com.myapp.appointmentsystem.model.Client;
import com.myapp.appointmentsystem.repository.ClientRepository;
import com.myapp.appointmentsystem.validation.AppointmentValidator;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AppointmentService {

	private final ClientRepository clientRepository;
	private final AppointmentRepository repository;
	
	
	public AppointmentService(AppointmentRepository repository,
            ClientRepository clientRepository) {
			this.repository = repository;
			this.clientRepository = clientRepository;
}
	
	public List<AppointmentResponse> getAppointments(Long clientId , LocalDate date) {
	    
	List<Appointment> appointments;

    if (clientId != null && date != null) {
        appointments = repository.findByClientIdAndDate(clientId, date);
    } else if (clientId != null) {
        appointments = repository.findByClientId(clientId);
    } else if (date != null) {
        appointments = repository.findByDate(date);
    } else {
        appointments = repository.findAll();
    }

    return appointments.stream().map(a -> new AppointmentResponse(
	                    a.getId(),
	                    a.getDate(),
	                    a.getTime(),
	                    a.getClient().getName()
	            ))
	            .toList();
	}
	
	public Appointment createAppointment(AppointmentRequest request) {
		
	    Client client = clientRepository.findById(request.getClientId())
	            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));

	    Appointment appointment = new Appointment();
	    appointment.setDate(request.getDate());
	    appointment.setTime(request.getTime());
	    appointment.setClient(client);

	    AppointmentValidator.validateAppointmentCreation(appointment, repository);
	    
	    return repository.save(appointment);
	}

	public List<LocalTime>  getAvailableSlots (LocalDate date) {
		
		List <Appointment> appointments= repository.findByDate(date);
		
		List <LocalTime> occupiedTimes = appointments.stream()
				.map(Appointment::getTime)
				.collect(Collectors.toList());
		
		List<LocalTime> availableSlots = new ArrayList<>();
		
		LocalTime start= LocalTime.of(9, 0);
		LocalTime end= LocalTime.of(18, 0);
		
		LocalTime current = start;
		
		while (!current.isAfter(end)) {
			if (!occupiedTimes.contains(current)) {
		           availableSlots.add(current);
		    }
			current= current.plusHours(1);
		}
		return availableSlots;
	}
	
	public void cancelAppointment(Long id) {
		Appointment appointment = repository.findById(id)
				.orElseThrow( ()-> new ResponseStatusException(
						HttpStatus.NOT_FOUND,"Appointment not found."
						));
		
		LocalDateTime appointmentDateTime = LocalDateTime.of(
				appointment.getDate(), appointment.getTime());
		
		if (appointmentDateTime.isBefore(LocalDateTime.now())) {
			throw new ResponseStatusException (HttpStatus.BAD_REQUEST,
					"Cannot cancel past appointment");
		}
		
		repository.delete(appointment);
		
	}
	
	
	
}



