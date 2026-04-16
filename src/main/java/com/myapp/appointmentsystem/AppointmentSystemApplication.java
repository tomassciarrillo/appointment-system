package com.myapp.appointmentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.myapp.appointmentsystem.model.Client;
import com.myapp.appointmentsystem.model.Appointment;
import com.myapp.appointmentsystem.repository.ClientRepository;
import com.myapp.appointmentsystem.repository.AppointmentRepository;



@SpringBootApplication
public class AppointmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentSystemApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner runner(ClientRepository clientRepository,
	                         AppointmentRepository appointmentRepository) {
	    return args -> {

	        // Crear cliente
	        Client client = new Client("Juan Perez", "juan@email.com");
	        clientRepository.save(client);

	        // Crear appointment
	        Appointment appointment = new Appointment(
	                java.time.LocalDate.now(),
	                java.time.LocalTime.of(10, 0),
	                client
	        );

	        appointmentRepository.save(appointment);

	        System.out.println("Client and Appointment saved.");
	    };
	}
	
	
	
	

}
