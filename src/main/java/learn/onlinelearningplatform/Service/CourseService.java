package learn.onlinelearningplatform.Service;

import jakarta.transaction.Transactional;
import learn.onlinelearningplatform.Entity.Course;
import learn.onlinelearningplatform.Entity.Role;
import learn.onlinelearningplatform.Entity.User;
import learn.onlinelearningplatform.dto.course.CourseCreateDto;
import learn.onlinelearningplatform.dto.course.CoursePatchDto;
import learn.onlinelearningplatform.dto.course.CourseResponseDto;
import learn.onlinelearningplatform.mapper.CourseMapper;
import learn.onlinelearningplatform.repositories.CourseRepository;
import learn.onlinelearningplatform.repositories.UserRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final UserRepositories userRepository;
    private final CourseMapper courseMapper;

    @Transactional
    public CourseResponseDto createCourse(CourseCreateDto dto) {
        User instructor = userRepository.findById(dto.instructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        // Check if user is actually an instructor
        if (instructor.getRole() != Role.INSTRUCTOR) {
            throw new RuntimeException("User is not an instructor");
        }

        Course course = courseMapper.toEntity(dto);
        course.setInstructor(instructor);

        Course savedCourse = courseRepository.save(course);
        return courseMapper.toResponseDto(savedCourse);
    }

    // ==================== GET ALL ====================
    public List<CourseResponseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courseMapper.toResponseDtoList(courses);
    }

    // ==================== GET BY ID ====================
    public CourseResponseDto getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return courseMapper.toResponseDto(course);
    }

    public List<CourseResponseDto> getCoursesByInstructor(Long instructorId) {
        List<Course> courses = courseRepository.findByInstructorId(instructorId);
        return courseMapper.toResponseDtoList(courses);
    }

    @Transactional
    public CourseResponseDto updateCourse(Long id, CourseCreateDto dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        User instructor = userRepository.findById(dto.instructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        courseMapper.updateCourseFromDto(dto, course);
        course.setInstructor(instructor);

        return courseMapper.toResponseDto(courseRepository.save(course));
    }


    @Transactional
    public CourseResponseDto patchCourse(Long id, CoursePatchDto dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        courseMapper.updateCourseFromPatch(dto, course);

        // If instructorId is provided
        if (dto.instructorId() != null) {
            User instructor = userRepository.findById(dto.instructorId())
                    .orElseThrow(() -> new RuntimeException("Instructor not found"));
            course.setInstructor(instructor);
        }

        return courseMapper.toResponseDto(courseRepository.save(course));
    }

    @Transactional
    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found");
        }
        courseRepository.deleteById(id);
    }
}