package org.spring.curso.msvc.paciente.service;

import org.spring.curso.msvc.paciente.dto.CreatePatientRequest;
import org.spring.curso.msvc.paciente.dto.PatientDto;
import org.spring.curso.msvc.paciente.entity.Patient;
import org.spring.curso.msvc.paciente.mapper.PatientMapper;
import org.spring.curso.msvc.paciente.repository.PatientRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper mapper;

    public PatientServiceImpl(PatientRepository patientRepository, PatientMapper mapper) {
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }

    @Override
    public Flux<PatientDto> getAllPatients() {
        return this.patientRepository.findAll()
                .map(patient -> this.mapper.patientToPatientDto(patient));
    }

    @Override
    public Mono<PatientDto> getPatientById(Long id) {
        return this.patientRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Error, Paciente no encontrado.")))
                .flatMap(patient -> {
                    if (patient.getStatus().equals(0)) {
                        return Mono.error(new RuntimeException("Error, Paciente no encontrado."));
                    }

                    return Mono.just(this.mapper.patientToPatientDto(patient));
                });
    }

    @Override
    public Mono<PatientDto> savePatient(CreatePatientRequest patientDto) {
        return this.patientRepository.existsByEmail(patientDto.getEmail())
                .flatMap(exists -> {
                    if (exists) {
                        return Mono.error(new RuntimeException("Error, el correo ya existe."));
                    }

                    return this.patientRepository.save(this.mapper.createPatientRequestToPatient(patientDto));
                })
                .map(patient -> this.mapper.patientToPatientDto(patient));
    }

    @Override
    public Mono<Void> updatePatient(Long id, PatientDto patientDto) {
        Mono<Patient> patientMono = this.patientRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Error, Paciente no encontrado.")));

        return patientMono.flatMap(patientDb -> {
            Patient patient = this.mapper.patientDtoToPatient(patientDto);
            patient.setId(patientDb.getId());
            return this.patientRepository.existsByEmail(patient.getEmail())
                    .flatMap(exist -> {
                        if (exist) {
                            return Mono.error(new RuntimeException("Error, el correo ya existe."));
                        }

                        return this.patientRepository.save(patient)
                                .then();
                    });
        });
    }

    @Override
    public Mono<Void> deletePatient(Long id) {
        Mono<Patient> patientMono = this.patientRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Error, Paciente no encontrado.")));

        return patientMono.flatMap(patient -> {
            patient.setStatus(0);
            return this.patientRepository.save(patient).then();
        });
    }

}
