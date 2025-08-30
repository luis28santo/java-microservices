package org.spring.curso.msvc.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


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

    private String reason;

}
