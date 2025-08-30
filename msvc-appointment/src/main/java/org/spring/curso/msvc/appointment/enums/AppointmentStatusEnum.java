package org.spring.curso.msvc.appointment.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum AppointmentStatusEnum {

    // 0: CANCELLED, 1: COMPLETED, 2: CONFIRMED, 3: PENDING
    CANCELLED(0, "CANCELLED"),
    COMPLETED(1, "COMPLETED"),
    CONFIRMED(2, "CONFIRMED"),
    PENDING(3, "PENDING");

    private int id;
    private String description;

    AppointmentStatusEnum(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static AppointmentStatusEnum getStatusById(int id) {
        Optional<AppointmentStatusEnum> optional = Arrays.stream(AppointmentStatusEnum.values())
                .filter(status -> status.getId() == id)
                .findFirst();

        if (optional.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return optional.get();
    }

    public static AppointmentStatusEnum getStatusByDescription(String description) {
        Optional<AppointmentStatusEnum> optional = Arrays.stream(AppointmentStatusEnum.values())
                .filter(status -> status.getDescription().equals(description))
                .findFirst();

        if (optional.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return optional.get();
    }


}
