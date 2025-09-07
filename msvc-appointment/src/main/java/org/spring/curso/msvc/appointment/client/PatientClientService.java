package org.spring.curso.msvc.appointment.client;

import org.spring.curso.msvc.appointment.client.model.CreatePatientRequest;
import org.spring.curso.msvc.appointment.client.model.PatientResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PatientClientService {

    private final WebClient patientWebClient;

    public PatientClientService(@Qualifier("patientWebClient") WebClient patientWebClient) {
        this.patientWebClient = patientWebClient;
    }

    public Mono<PatientResponse> getPatientById(Long id) {
        return patientWebClient.get()
                .uri("/patients/{id}", id)
                .retrieve()
                .bodyToMono(PatientResponse.class)
                .log();
    }

    public Mono<PatientResponse> savePatient(CreatePatientRequest patientRequest) {
        return patientWebClient.post()
                .uri("/patients")
                .bodyValue(patientRequest)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, response -> response.bodyToMono(String.class)
                        .flatMap(
                                errorMessage -> Mono.error(new RuntimeException("Error, " + errorMessage))
                        )
                )
                .bodyToMono(PatientResponse.class)
                .log();
    }
}
