package learn.onlinelearningplatform.controller;

import learn.onlinelearningplatform.Service.CourseService;
import learn.onlinelearningplatform.dto.course.CourseCreateDto;
import learn.onlinelearningplatform.dto.course.CoursePatchDto;
import learn.onlinelearningplatform.dto.course.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDto> createCourse(@RequestBody CourseCreateDto dto) {
        CourseResponseDto created = courseService.createCourse(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        List<CourseResponseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> getCourseById(@PathVariable Long id) {
        CourseResponseDto course = courseService.getCourseById(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<List<CourseResponseDto>> getCoursesByInstructor
            (@PathVariable Long instructorId) {
        List<CourseResponseDto> courses = courseService.getCoursesByInstructor(instructorId);
        return ResponseEntity.ok(courses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDto> updateCourse(
            @PathVariable Long id,
            @RequestBody CourseCreateDto dto) {

        CourseResponseDto updated = courseService.updateCourse(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CourseResponseDto> patchCourse(
            @PathVariable Long id,
            @RequestBody CoursePatchDto dto) {

        CourseResponseDto updated = courseService.patchCourse(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
