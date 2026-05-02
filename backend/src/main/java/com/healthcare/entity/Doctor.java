package com.healthcare.entity;
import jakarta.persistence.*;import lombok.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Doctor { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String name; @Column(nullable=false) private String specialization; @OneToOne private User user; }
