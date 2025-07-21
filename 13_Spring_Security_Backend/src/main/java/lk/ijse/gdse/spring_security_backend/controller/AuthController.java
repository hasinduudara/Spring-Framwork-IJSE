package lk.ijse.gdse.spring_security_backend.controller;

import lk.ijse.gdse.spring_security_backend.dto.APIResponse;
import lk.ijse.gdse.spring_security_backend.dto.AuthDTO;
import lk.ijse.gdse.spring_security_backend.dto.RegisterDTO;
import lk.ijse.gdse.spring_security_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse> registerUser(@RequestBody RegisterDTO registerDTO){
        return ResponseEntity.ok(new APIResponse(
                200,
                "OK",
                authService.register(registerDTO)
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody AuthDTO authDTO){
        return ResponseEntity.ok(new APIResponse(
                200,
                "OK",
                authService.authenticate(authDTO)
        ));
    }
}
