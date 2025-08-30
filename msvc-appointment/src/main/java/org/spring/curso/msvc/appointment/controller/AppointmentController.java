package org.spring.curso.msvc.appointment.controller;

import org.spring.curso.msvc.appointment.dto.UpdateAppintmentDto;
import org.spring.curso.msvc.appointment.service.AppointmentService;
import org.spring.curso.msvc.appointment.dto.AppointmentDto;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public Flux<AppointmentDto> getAllAppointments() {
        return this.appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Mono<AppointmentDto> getAllAppointments(@PathVariable("id") Long id) {
        return this.appointmentService.getAppointmentById(id);
    }

    @PostMapping
    public Mono<Void> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        return this.appointmentService.createAppointment(appointmentDto);
    }

    @PutMapping("/{id}")
    public Mono<AppointmentDto> getAllAppointments(@PathVariable("id") Long id,
                                                   @RequestBody UpdateAppintmentDto updateAppintmentDto) {
        return this.appointmentService.updateAppointment(id, updateAppintmentDto);
    }

    @GetMapping("/patient/{id}")
    public Flux<AppointmentDto> getAppointmentsByPatientId(@PathVariable("id") Long id) {
        return this.appointmentService.getAppointmentsByPatientId(id);
    }

}
