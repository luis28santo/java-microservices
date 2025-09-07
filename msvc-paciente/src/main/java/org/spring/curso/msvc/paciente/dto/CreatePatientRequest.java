package org.spring.curso.msvc.paciente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientRequest {

    @NotBlank(message = "{create.patient.firstName}")
    private String firstName;

    @NotBlank(message = "{create.patient.lastName}")
    private String lastName;

    @NotNull(message = "{create.patient.birthDate}")
    private LocalDate birthDate;

    @NotBlank(message = "{create.patient.email}")
    private String email;

    private String statusDescription;

}
