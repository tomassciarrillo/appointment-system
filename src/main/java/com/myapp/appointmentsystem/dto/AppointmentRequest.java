package com.myapp.appointmentsystem.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentRequest {

    private LocalDate date;
    private LocalTime time;
    private Long clientId;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
