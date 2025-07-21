package lk.ijse.gdse.spring_security_backend.service;

import lk.ijse.gdse.spring_security_backend.dto.AuthDTO;
import lk.ijse.gdse.spring_security_backend.dto.AuthResponseDTO;
import lk.ijse.gdse.spring_security_backend.dto.RegisterDTO;
import lk.ijse.gdse.spring_security_backend.entity.Role;
import lk.ijse.gdse.spring_security_backend.entity.User;
import lk.ijse.gdse.spring_security_backend.repository.UserRepository;
import lk.ijse.gdse.spring_security_backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDTO authenticate(AuthDTO authDTO) {
        User user = userRepository.findByUsername(authDTO.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (!passwordEncoder.matches(
                authDTO.getPassword(),
                user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        String token = jwtUtil.generateToken(authDTO.getUsername());
        return new AuthResponseDTO(token);
    }

    public String register(RegisterDTO registerDTO) {
        if (userRepository.findByUsername(
                registerDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        User user = User .builder()
                .username(registerDTO.getUsername())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role(Role.valueOf(registerDTO.getRole()))
                .build();
        userRepository.save(user);
        return "User registered successfully";
    }
}
