package org.spring.curso.msvc.appointment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")
public class Appointment {

    @Id
    private Long id;

    @Column(value = "patient_id")
    private Integer patientId;

    private String doctor;

    @Column(value = "appointment_date")
    private LocalDate appointmentDate;

    @Column(value = "appointment_time")
    private LocalTime appointmentTime;

    private Integer status; // 0: CANCELLED, 1: COMPLETED, 2: CONFIRMED, 3: PENDING

    private String reason;

    @Column(value = "created_at")
    private LocalDateTime createdAt;

    @Column(value = "updated_at")
    private LocalDateTime updatedAt;

}
