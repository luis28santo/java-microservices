package org.spring.curso.msvc.paciente.service;

import org.spring.curso.msvc.paciente.dto.PatientDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientService {

    Flux<PatientDto> getAllPatients();

    Mono<PatientDto> getPatientById(Long id);

    Mono<Void> savePatient(PatientDto patientDto);

    Mono<Void> updatePatient(Long id, PatientDto patientDto);

    Mono<Void> deletePatient(Long id);

}
