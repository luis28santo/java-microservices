package org.spring.curso.msvc.paciente.controller;

import org.spring.curso.msvc.paciente.dto.PatientDto;
import org.spring.curso.msvc.paciente.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<Flux<PatientDto>> getAllPatients() {
        return ResponseEntity.ok(this.patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<PatientDto>> getAllPatients(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(this.patientService.getPatientById(id));
    }

    @PostMapping
    public ResponseEntity<Mono<Void>> savePatient(@RequestBody PatientDto patientDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.patientService.savePatient(patientDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<Void>> updatePatient(@PathVariable("id") Long id, @RequestBody PatientDto patientDto) {
        return ResponseEntity.ok(this.patientService.updatePatient(id, patientDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mono<Void>> deletePatient(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(this.patientService.deletePatient(id));
    }
}
