package com.example.clinic.patient.controller;

import com.example.clinic.patient.dto.PatientCreationDTO;
import com.example.clinic.patient.dto.SimplePatientCreationDTO;
import com.example.clinic.patient.entity.Patient;
import com.example.clinic.patient.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PatientCreationController {

    private final PatientService patientService;

    @MessageMapping("/create")
    @SendTo("/api/patients/ws/topic/created")
    public SimplePatientCreationDTO createPatient(SimplePatientCreationDTO patientDto) {
        System.out.println(patientDto);
        PatientCreationDTO patientCreationDTO = new PatientCreationDTO(patientDto.name(), patientDto.dateOfBirth().toLocalDate(), patientDto.email());
        Patient patient = patientService.createPatient(patientCreationDTO);
        System.out.println(patientCreationDTO);
        return patientDto;
    }
}
