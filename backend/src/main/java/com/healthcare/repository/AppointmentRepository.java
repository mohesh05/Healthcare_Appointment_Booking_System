package com.healthcare.repository;
import com.healthcare.entity.*;import java.time.LocalDateTime;import java.util.List;import org.springframework.data.jpa.repository.JpaRepository;
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{ boolean existsByDoctorAndAppointmentDateAndStatusNot(Doctor doctor, LocalDateTime appointmentDate, AppointmentStatus status); List<Appointment> findByUser(User user); List<Appointment> findByDoctor(Doctor doctor); }
