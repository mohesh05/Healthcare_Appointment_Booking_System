package com.healthcare.dto;
import com.healthcare.entity.Role;import jakarta.validation.constraints.*;import java.time.LocalDateTime;import lombok.*;
public class Dtos {
 @Getter @Setter public static class RegisterRequest { @NotBlank private String username; @NotBlank private String password; @Email private String email; private Role role = Role.PATIENT; }
 @Getter @Setter public static class LoginRequest { @NotBlank private String username; @NotBlank private String password; }
 @AllArgsConstructor @Getter public static class AuthResponse { private String token; private String role; }
 @Getter @Setter public static class DoctorRequest { @NotBlank private String name; @NotBlank private String specialization; }
 @Getter @Setter public static class AppointmentRequest { @NotNull @Future private LocalDateTime appointmentDate; }
}
