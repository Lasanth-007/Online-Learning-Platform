package learn.onlinelearningplatform.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Course extends BaseEntity {
    private String title;
    private String description;
    private Double price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private User instructor;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "course"
    )
    private List<Section> sections;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Builder.Default
    private List<Enrollment> enrollments = new ArrayList<>();
}
