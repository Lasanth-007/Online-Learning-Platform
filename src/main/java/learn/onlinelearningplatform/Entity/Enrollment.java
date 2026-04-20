package learn.onlinelearningplatform.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import learn.onlinelearningplatform.embedded.EnrollmentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
public class Enrollment {
    @EmbeddedId
    private EnrollmentId id;

    @JsonBackReference
    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id" )
    private User user;

    @JsonBackReference
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime enrolledAt;


}
