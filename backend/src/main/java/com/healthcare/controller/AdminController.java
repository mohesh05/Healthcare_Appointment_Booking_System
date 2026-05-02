package com.healthcare.controller;
import com.healthcare.dto.Dtos.DoctorRequest;import com.healthcare.repository.UserRepository;import com.healthcare.service.*;import jakarta.validation.Valid;import lombok.RequiredArgsConstructor;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/admin") @RequiredArgsConstructor
public class AdminController { private final DoctorService doctorService; private final UserRepository userRepository; private final AppointmentService appointmentService;
 @PostMapping("/doctor") public Object create(@Valid @RequestBody DoctorRequest req){ return doctorService.createDoctor(req); }
 @GetMapping("/users") public Object users(){ return userRepository.findAll(); }
 @GetMapping("/appointments") public Object appointments(){ return appointmentService.all(); }
}
