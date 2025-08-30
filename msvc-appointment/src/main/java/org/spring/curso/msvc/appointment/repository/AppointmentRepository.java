package org.spring.curso.msvc.appointment.repository;

import org.spring.curso.msvc.appointment.entity.Appointment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AppointmentRepository extends ReactiveCrudRepository<Appointment, Long> {

    Flux<Appointment> findByPatientId(Long id);

}
