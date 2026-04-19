package learn.onlinelearningplatform.repositories;

import learn.onlinelearningplatform.Entity.Enrollment;
import learn.onlinelearningplatform.embedded.EnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {

    List<Enrollment> findByUser_Id(Long userId);

    List<Enrollment> findByCourse_Id(Long courseId);

    boolean existsByUser_IdAndCourse_Id(Long userId, Long courseId);


}
