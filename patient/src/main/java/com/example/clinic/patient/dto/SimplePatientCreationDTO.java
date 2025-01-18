package com.example.clinic.patient.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record SimplePatientCreationDTO(

//        @NotBlank(message = "Name is required")
//        @Size(max = 100, message = "Name should not exceed 100 characters")
        String name,

//        @NotNull(message = "Date of birth is required")
        LocalDateTime dateOfBirth,

//        @NotBlank(message = "Email is required")
//        @Email(message = "Invalid email format")
//        @Size(max = 100, message = "Email should not exceed 100 characters")
        String email
) {
}