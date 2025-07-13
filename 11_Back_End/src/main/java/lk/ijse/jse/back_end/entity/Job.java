package lk.ijse.jse.back_end.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String jobTitle;
    private String company;
    private String location;
    private String type;
    private String jobDescription;
    private String active;

    public void setActive(String active) {
        this.active = active;
    }

    public String isActive() {
        return this.active;
    }
}
