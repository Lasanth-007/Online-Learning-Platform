package learn.onlinelearningplatform.repositories;

import learn.onlinelearningplatform.Entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {


    List<Resource> findByNameContainingIgnoreCase(String name);

    // List<Resource> findByLectureId(Long lectureId);

    List<Resource> findAllByOrderByNameAsc();
}
