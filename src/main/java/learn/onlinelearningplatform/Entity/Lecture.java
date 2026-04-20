package learn.onlinelearningplatform.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Lecture extends BaseEntity {

    private String title;

    private Integer durationInMinutes;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
