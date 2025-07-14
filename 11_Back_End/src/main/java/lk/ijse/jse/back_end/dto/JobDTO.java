package lk.ijse.jse.back_end.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDTO {
    private int id;

    @NotBlank(message = "Job title cannot be blank")
    private String jobTitle;

    @NotBlank(message = "Company name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Company name can only contain letters, numbers, and spaces")
    private String company;

    @NotBlank(message = "Location cannot be blank")
    private String location;

    @NotNull(message = "Job type cannot be null")
    private String type;

    @Size(min =  1, max = 50, message = "Job description must be between 1 and 50 characters")
    private String jobDescription;

    private boolean active;

    public Integer getId() {
        return id;
    }
}
