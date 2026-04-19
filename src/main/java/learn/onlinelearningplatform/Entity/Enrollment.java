package learn.onlinelearningplatform.Entity;

import jakarta.persistence.*;
import learn.onlinelearningplatform.embedded.EnrollmentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Enrollment {
    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id" )
    private User user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime enrolledAt;


}
