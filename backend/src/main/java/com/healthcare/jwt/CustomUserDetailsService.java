package com.healthcare.jwt;
import com.healthcare.entity.User;import com.healthcare.repository.UserRepository;import lombok.RequiredArgsConstructor;import org.springframework.security.core.authority.SimpleGrantedAuthority;import org.springframework.security.core.userdetails.*;import org.springframework.stereotype.Service;
import java.util.List;
@Service @RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService { private final UserRepository userRepository;
 public UserDetails loadUserByUsername(String username){ User u=userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("not found")); return new org.springframework.security.core.userdetails.User(u.getUsername(),u.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_"+u.getRole().name()))); }
}
