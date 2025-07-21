package lk.ijse.gdse.spring_security_backend.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String role; // User or Admin
}
