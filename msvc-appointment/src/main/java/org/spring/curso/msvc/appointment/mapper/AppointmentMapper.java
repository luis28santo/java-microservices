package org.spring.curso.msvc.appointment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.spring.curso.msvc.appointment.dto.AppointmentDto;
import org.spring.curso.msvc.appointment.entity.Appointment;
import org.spring.curso.msvc.appointment.enums.AppointmentStatusEnum;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(source = "status", target = "statusDescription", qualifiedByName = "getStatusDescription")
    AppointmentDto appointmentToAppointmentDto(Appointment appointment);

    @Mapping(source = "statusDescription", target = "status", qualifiedByName = "getStatusId")
    Appointment appointmentDtoToAppointment(AppointmentDto appointmentDto);

    @Named(value = "getStatusDescription")
    default String getStatusDescription(int id) {
        try {
            return AppointmentStatusEnum.getStatusById(id).getDescription();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, el statusId es invalido");
        }
    }

    @Named(value = "getStatusId")
    default int getStatusId(String description) {
        try {
            return AppointmentStatusEnum.getStatusByDescription(description).getId();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error, el statusId es invalido");
        }
    }
}
