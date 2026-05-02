package com.healthcare.controller;
import com.healthcare.dto.Dtos.AppointmentRequest;import com.healthcare.service.*;import jakarta.validation.Valid;import lombok.RequiredArgsConstructor;import org.springframework.security.core.Authentication;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/patient") @RequiredArgsConstructor
public class PatientController { private final DoctorService doctorService; private final AppointmentService appointmentService; private final UserService userService;
 @GetMapping("/doctors") public Object doctors(){ return doctorService.list(); }
 @PostMapping("/appointment") public Object book(@RequestParam Long doctorId,@Valid @RequestBody AppointmentRequest req, Authentication a){ return appointmentService.book(doctorId,req,userService.findByUsername(a.getName())); }
 @GetMapping("/appointments") public Object appointments(Authentication a){ return appointmentService.patient(userService.findByUsername(a.getName())); }
 @PutMapping("/appointment/cancel/{id}") public Object cancel(@PathVariable Long id,Authentication a){ return appointmentService.cancel(id,userService.findByUsername(a.getName())); }
}
