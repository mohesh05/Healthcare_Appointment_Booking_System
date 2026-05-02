package com.healthcare.repository;
import com.healthcare.entity.Doctor;import com.healthcare.entity.User;import java.util.Optional;import org.springframework.data.jpa.repository.JpaRepository;
public interface DoctorRepository extends JpaRepository<Doctor,Long>{ Optional<Doctor> findByUser(User user); }
