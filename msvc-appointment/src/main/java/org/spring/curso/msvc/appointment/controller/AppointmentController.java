package org.spring.curso.msvc.appointment.controller;

import org.spring.curso.msvc.appointment.service.AppointmentService;
import org.spring.curso.msvc.appointment.dto.AppointmentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public Flux<AppointmentDto> getAllAppointments(){
        return this.appointmentService.getAllAppointments();
    }
}
