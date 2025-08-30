package org.spring.curso.msvc.appointment.service;

import org.spring.curso.msvc.appointment.dto.AppointmentDto;
import org.spring.curso.msvc.appointment.mapper.AppointmentMapper;
import org.spring.curso.msvc.appointment.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentServiceImpl(AppointmentRepository repository, AppointmentMapper appointmentMapper) {
        this.repository = repository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public Mono<AppointmentDto> createAppointment(AppointmentDto appointmentDto) {
        return null;
    }

    @Override
    public Flux<AppointmentDto> getAllAppointments() {
        return this.repository.findAll()
                .map(appointment -> this.appointmentMapper.appointmentToAppointmentDto(appointment));
    }

    @Override
    public Mono<AppointmentDto> getAppointmentById(Long id) {
        return null;
    }

    @Override
    public Mono<AppointmentDto> updateAppointment(AppointmentDto appointmentDto) {
        return null;
    }

}
