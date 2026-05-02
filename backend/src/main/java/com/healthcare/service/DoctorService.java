package com.healthcare.service;
import com.healthcare.dto.Dtos.DoctorRequest;import com.healthcare.entity.*;import com.healthcare.exception.ApiException;import com.healthcare.repository.*;import java.util.List;import lombok.RequiredArgsConstructor;import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class DoctorService { private final DoctorRepository doctorRepository; private final UserRepository userRepository;
 public Doctor createDoctor(DoctorRequest req){ User doctorUser = userRepository.save(User.builder().username(req.getName().replaceAll("\\s+","").toLowerCase()+System.currentTimeMillis()).password("{noop}temp").email(req.getName().replaceAll("\\s+","").toLowerCase()+"@hospital.local").role(Role.DOCTOR).build());
 return doctorRepository.save(Doctor.builder().name(req.getName()).specialization(req.getSpecialization()).user(doctorUser).build()); }
 public List<Doctor> list(){ return doctorRepository.findAll(); }
 public Doctor byId(Long id){ return doctorRepository.findById(id).orElseThrow(()->new ApiException("Doctor not found")); }
 public Doctor byUser(User user){ return doctorRepository.findByUser(user).orElseThrow(()->new ApiException("Doctor profile not found")); }
}
