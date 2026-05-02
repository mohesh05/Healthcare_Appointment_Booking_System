package com.healthcare.entity;
import jakarta.persistence.*;import lombok.*;
@Entity @Table(name="users",uniqueConstraints={@UniqueConstraint(columnNames={"username"}),@UniqueConstraint(columnNames={"email"})})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false) private String username; @Column(nullable=false) private String password; @Column(nullable=false) private String email; @Enumerated(EnumType.STRING) @Column(nullable=false) private Role role; }
