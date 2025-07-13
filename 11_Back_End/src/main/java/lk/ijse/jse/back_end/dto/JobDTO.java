package lk.ijse.jse.back_end.dto;

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
    private String jobTitle;
    private String company;
    private String location;
    private String type;
    private String jobDescription;
//    private String status;
    private boolean active;

    public Integer getId() {
        return id;
    }
}
