package org.spring.curso.msvc.appointment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring.curso.msvc.appointment.client.model.PatientResponse;

import java.time.LocalDate;
import java.time.LocalTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {

    private Long id;

    private Integer patientId;

    private String doctor;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private String statusDescription;

    private Integer statusId;

    private String reason;

    private PatientResponse patientResponse;

}
