package org.spring.curso.msvc.paciente.repository;

import org.spring.curso.msvc.paciente.entity.Patient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {

    Mono<Boolean> existsByEmail(String email);

}
