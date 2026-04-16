package com.myapp.appointmentsystem.repository;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;

import com.myapp.appointmentsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	boolean existsByDateAndTime(LocalDate date, LocalTime time);
	
	List <Appointment> findByDate (LocalDate date);
	
	List <Appointment> findByClientId (Long clientId);
	
	List <Appointment> findByClientIdAndDate (Long clientId, LocalDate date);
}



