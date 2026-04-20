package learn.onlinelearningplatform.controller;

import learn.onlinelearningplatform.Service.EnrollmentService;
import learn.onlinelearningplatform.dto.enrollment.EnrollmentCreateDto;
import learn.onlinelearningplatform.dto.enrollment.EnrollmentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponseDto> createEnrollment
    (@RequestBody EnrollmentCreateDto dto) {
        EnrollmentResponseDto created = enrollmentService.createEnrollment(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EnrollmentResponseDto>> getEnrollmentsByUser
            (@PathVariable Long userId) {
        List<EnrollmentResponseDto> enrollments = enrollmentService.getEnrollmentsByUser(userId);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<EnrollmentResponseDto>> getEnrollmentsByCourse
            (@PathVariable Long courseId) {
        List<EnrollmentResponseDto> enrollments = enrollmentService.getEnrollmentsByCourse(courseId);
        return ResponseEntity.ok(enrollments);
    }

    @DeleteMapping("/user/{userId}/course/{courseId}")
    public ResponseEntity<Void> deleteEnrollment(
            @PathVariable Long userId,
            @PathVariable Long courseId) {

        enrollmentService.deleteEnrollment(userId, courseId);
        return ResponseEntity.noContent().build();
    }
}
