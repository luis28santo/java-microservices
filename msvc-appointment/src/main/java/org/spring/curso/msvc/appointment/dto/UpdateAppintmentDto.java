package org.spring.curso.msvc.appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAppintmentDto {

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private Integer statusId;

}
