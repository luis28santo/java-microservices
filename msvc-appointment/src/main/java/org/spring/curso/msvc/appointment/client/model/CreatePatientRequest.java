package org.spring.curso.msvc.appointment.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientRequest {

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String email;

    private String statusDescription;
}
