package org.spring.curso.msvc.appointment.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {

    private static final String PATIENT_BASE_URL = "http://localhost:8090";

    @Bean("patientWebClient")
    public WebClient patientWebClient(WebClient.Builder builder) {
        return builder.baseUrl(PATIENT_BASE_URL)
                .build();
    }


}
