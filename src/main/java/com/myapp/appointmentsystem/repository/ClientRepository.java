package com.myapp.appointmentsystem.repository;

import com.myapp.appointmentsystem.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
