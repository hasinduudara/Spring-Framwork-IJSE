package lk.ijse.gdse.spring_security_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class APIResponse {
    private int code;
    private String status;
    private Object data;
}
