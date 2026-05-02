package com.healthcare.service;
import com.healthcare.dto.Dtos.AppointmentRequest;import com.healthcare.entity.*;import com.healthcare.exception.ApiException;import com.healthcare.repository.AppointmentRepository;import java.util.List;import lombok.RequiredArgsConstructor;import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class AppointmentService { private final AppointmentRepository appointmentRepository; private final DoctorService doctorService;
 public Appointment book(Long doctorId, AppointmentRequest req, User patient){ Doctor doctor = doctorService.byId(doctorId); if(appointmentRepository.existsByDoctorAndAppointmentDateAndStatusNot(doctor,req.getAppointmentDate(),AppointmentStatus.CANCELLED)) throw new ApiException("Doctor slot unavailable");
 return appointmentRepository.save(Appointment.builder().doctor(doctor).user(patient).appointmentDate(req.getAppointmentDate()).status(AppointmentStatus.BOOKED).build()); }
 public List<Appointment> patient(User user){ return appointmentRepository.findByUser(user); }
 public Appointment cancel(Long id, User user){ Appointment a=appointmentRepository.findById(id).orElseThrow(()->new ApiException("Appointment not found")); if(!a.getUser().getId().equals(user.getId())) throw new ApiException("Unauthorized"); a.setStatus(AppointmentStatus.CANCELLED); return appointmentRepository.save(a); }
 public List<Appointment> doctor(User user){ return appointmentRepository.findByDoctor(doctorService.byUser(user)); }
 public Appointment updateStatus(Long id, String status){ Appointment a=appointmentRepository.findById(id).orElseThrow(()->new ApiException("Appointment not found")); a.setStatus(AppointmentStatus.valueOf(status.toUpperCase())); return appointmentRepository.save(a);} 
 public List<Appointment> all(){ return appointmentRepository.findAll(); }
}
