package learn.onlinelearningplatform.repositories;

import learn.onlinelearningplatform.Entity.Course;
import org.springframework.boot.util.LambdaSafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findByInstructorId(Long instructorId);

    List<Course> findByTitleContainingIgnoreCase(String title);

    // Find courses by price range
    List<Course> findByPriceBetween(Double minPrice, Double maxPrice);
}
