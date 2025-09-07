package org.spring.curso.msvc.appointment.service;

import org.spring.curso.msvc.appointment.dto.AppointmentDto;
import org.spring.curso.msvc.appointment.dto.CreateAppointmentRequest;
import org.spring.curso.msvc.appointment.dto.UpdateAppintmentDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AppointmentService {

    Mono<Void> createAppointment(AppointmentDto appointmentDto);

    Flux<AppointmentDto> getAllAppointments();

    Mono<AppointmentDto> getAppointmentById(Long id);

    Mono<AppointmentDto> updateAppointment(Long id, UpdateAppintmentDto updateAppintmentDto);

    Flux<AppointmentDto> getAppointmentsByPatientId(Long id);

    Mono<Void> createAppointmentAndPatient(CreateAppointmentRequest createAppointmentRequest);
}
