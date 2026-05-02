package com.healthcare.controller;
import com.healthcare.service.*;import lombok.RequiredArgsConstructor;import org.springframework.security.core.Authentication;import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/doctor") @RequiredArgsConstructor
public class DoctorController { private final AppointmentService appointmentService; private final UserService userService;
 @GetMapping("/appointments") public Object appointments(Authentication a){ return appointmentService.doctor(userService.findByUsername(a.getName())); }
 @PutMapping("/appointment/update/{id}") public Object update(@PathVariable Long id,@RequestParam String status){ return appointmentService.updateStatus(id,status); }
 @PostMapping("/availability") public Object availability(){ return Map.of("message","Availability updated"); }
}
