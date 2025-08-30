package org.spring.curso.msvc.appointment.client;

import org.spring.curso.msvc.appointment.client.model.PatientResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PatientClient {

    private final WebClient patientWebClient;

    public PatientClient(@Qualifier("patientWebClient") WebClient patientWebClient) {
        this.patientWebClient = patientWebClient;
    }

    public Mono<PatientResponse> getPatientById(Long id) {
        return patientWebClient.get()
                .uri("/patients/{id}", id)
                .retrieve()
                .bodyToMono(PatientResponse.class)
                .log();
    }
}
