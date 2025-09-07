package org.spring.curso.msvc.appointment.service;

import org.spring.curso.msvc.appointment.client.PatientClientService;
import org.spring.curso.msvc.appointment.dto.AppointmentDto;
import org.spring.curso.msvc.appointment.dto.UpdateAppintmentDto;
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

    private final PatientClientService patientClientService;

    public AppointmentServiceImpl(AppointmentRepository repository, AppointmentMapper appointmentMapper, PatientClientService patientClientService) {
        this.repository = repository;
        this.mapper = appointmentMapper;
        this.patientClientService = patientClientService;
    }

    @Override
    public Mono<Void> createAppointment(AppointmentDto appointmentDto) {
        return Mono.just(this.mapper.appointmentDtoToAppointment(appointmentDto))
                .flatMap(appointment ->
                        this.patientClientService.getPatientById(appointment.getPatientId().longValue())
                                .flatMap(patient -> this.repository.save(appointment))
                ).then();
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
                .flatMap(appointment ->
                        this.patientClientService.getPatientById(appointment.getPatientId().longValue())
                                .flatMap(patient -> {
                                    AppointmentDto appointmentDto = this.mapper.appointmentToAppointmentDto(appointment);
                                    appointmentDto.setPatientResponse(patient);
                                    return Mono.just(appointmentDto);
                                })
                );
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

    @Override
    public Flux<AppointmentDto> getAppointmentsByPatientId(Long id) {
        return this.patientClientService.getPatientById(id)
                .flatMapMany(patient -> this.repository.findByPatientId(id.longValue()))
                .map(appointment -> this.mapper.appointmentToAppointmentDto(appointment));
    }

}
