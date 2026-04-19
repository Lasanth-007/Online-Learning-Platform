package learn.onlinelearningplatform.repositories;

import learn.onlinelearningplatform.Entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture,Long> {
    List<Lecture> findBySectionId(Long sectionId);

    List<Lecture> findBySectionCourseId(Long courseId);

    List<Lecture> findByTitleContainingIgnoreCase(String title);

    List<Lecture> findBySectionIdOrderByIdAsc(Long sectionId);
}
