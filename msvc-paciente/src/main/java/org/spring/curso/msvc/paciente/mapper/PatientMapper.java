package org.spring.curso.msvc.paciente.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.spring.curso.msvc.paciente.dto.PatientDto;
import org.spring.curso.msvc.paciente.entity.Patient;

import java.util.Objects;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(source = "status", target = "statusDescription", qualifiedByName = "getStatusDescription")
    PatientDto patientToPatientDto(Patient patient);


    @Mapping(source = "statusDescription", target = "status", qualifiedByName = "getStatusId")
    Patient patientDtoToPatient(PatientDto patientDto);

    @Named(value = "getStatusDescription")
    default String getStatusDescription(Integer status) {
        return !Objects.isNull(status) && status.equals(1) ? "ACTIVE" : "INACTIVE";
    }

    @Named(value = "getStatusId")
    default Integer getStatusId(String status) {

        if(Objects.isNull(status)) return null;

        return status.equals("ACTIVE") ? 1 : 0;
    }

}
