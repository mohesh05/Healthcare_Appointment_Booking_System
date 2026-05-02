package com.healthcare.controller;
import com.healthcare.dto.Dtos.*;import com.healthcare.jwt.JwtUtil;import com.healthcare.service.UserService;import jakarta.validation.Valid;import lombok.RequiredArgsConstructor;import org.springframework.security.authentication.*;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") @RequiredArgsConstructor
public class AuthController { private final UserService userService; private final AuthenticationManager authenticationManager; private final JwtUtil jwtUtil;
 @PostMapping("/register") public String register(@Valid @RequestBody RegisterRequest req){ userService.register(req); return "Registered"; }
 @PostMapping("/login") public AuthResponse login(@Valid @RequestBody LoginRequest req){ authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(),req.getPassword())); var u=userService.findByUsername(req.getUsername()); return new AuthResponse(jwtUtil.generate(u.getUsername(),u.getRole().name()),u.getRole().name()); }
}
