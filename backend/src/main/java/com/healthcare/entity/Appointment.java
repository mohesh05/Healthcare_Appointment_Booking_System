package com.healthcare.entity;
import java.time.LocalDateTime;import jakarta.persistence.*;import lombok.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Appointment { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private LocalDateTime appointmentDate; @Enumerated(EnumType.STRING) @Column(nullable=false) private AppointmentStatus status; @ManyToOne(optional=false) private Doctor doctor; @ManyToOne(optional=false) private User user; }
