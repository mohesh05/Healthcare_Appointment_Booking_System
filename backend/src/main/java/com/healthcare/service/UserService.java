package com.healthcare.service;
import com.healthcare.dto.Dtos.*;import com.healthcare.entity.*;import com.healthcare.exception.ApiException;import com.healthcare.repository.UserRepository;import lombok.RequiredArgsConstructor;import org.springframework.security.crypto.password.PasswordEncoder;import org.springframework.stereotype.Service;
@Service @RequiredArgsConstructor
public class UserService {
 private final UserRepository userRepository; private final PasswordEncoder passwordEncoder;
 public User register(RegisterRequest req){ if(userRepository.existsByUsername(req.getUsername())||userRepository.existsByEmail(req.getEmail())) throw new ApiException("User already exists");
 return userRepository.save(User.builder().username(req.getUsername()).password(passwordEncoder.encode(req.getPassword())).email(req.getEmail()).role(req.getRole()).build()); }
 public User findByUsername(String u){ return userRepository.findByUsername(u).orElseThrow(()->new ApiException("User not found")); }
}
