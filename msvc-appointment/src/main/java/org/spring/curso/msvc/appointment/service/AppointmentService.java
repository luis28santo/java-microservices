package org.spring.curso.msvc.appointment.service;

import org.spring.curso.msvc.appointment.dto.AppointmentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AppointmentService {

    Mono<AppointmentDto> createAppointment(AppointmentDto appointmentDto);

    Flux<AppointmentDto> getAllAppointments();

    Mono<AppointmentDto> getAppointmentById(Long id);

    Mono<AppointmentDto> updateAppointment(AppointmentDto appointmentDto);

}
