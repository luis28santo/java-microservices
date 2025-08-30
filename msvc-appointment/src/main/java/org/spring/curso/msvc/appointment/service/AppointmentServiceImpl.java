package org.spring.curso.msvc.appointment.service;

import org.spring.curso.msvc.appointment.dto.AppointmentDto;
import org.spring.curso.msvc.appointment.dto.UpdateAppintmentDto;
import org.spring.curso.msvc.appointment.entity.Appointment;
import org.spring.curso.msvc.appointment.mapper.AppointmentMapper;
import org.spring.curso.msvc.appointment.repository.AppointmentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final AppointmentMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository repository, AppointmentMapper appointmentMapper) {
        this.repository = repository;
        this.mapper = appointmentMapper;
    }

    @Override
    public Mono<Void> createAppointment(AppointmentDto appointmentDto) {
        return Mono.just(this.mapper.appointmentDtoToAppointment(appointmentDto))
                .flatMap(appointment -> this.repository.save(appointment))
                .then();
    }

    @Override
    public Flux<AppointmentDto> getAllAppointments() {
        return this.repository.findAll()
                .map(appointment -> this.mapper.appointmentToAppointmentDto(appointment));
    }

    @Override
    public Mono<AppointmentDto> getAppointmentById(Long id) {
        return this.repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Error, cita no encontrada")))
                .flatMap(appointment -> Mono.just(this.mapper.appointmentToAppointmentDto(appointment)));
    }

    @Override
    public Mono<AppointmentDto> updateAppointment(Long id, UpdateAppintmentDto updateAppintmentDto) {
        return this.repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Error, cita no encontrada")))
                .flatMap(appointmentDb -> {

                    appointmentDb.setAppointmentTime(updateAppintmentDto.getAppointmentTime());
                    appointmentDb.setAppointmentDate(updateAppintmentDto.getAppointmentDate());
                    appointmentDb.setStatus(updateAppintmentDto.getStatusId());
                    appointmentDb.setUpdatedAt(LocalDateTime.now());

                    return this.repository.save(appointmentDb)
                            .flatMap(appointment -> Mono.just(this.mapper.appointmentToAppointmentDto(appointment)));
                });
    }

}
