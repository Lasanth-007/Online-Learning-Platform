package learn.onlinelearningplatform.dto.enrollment;

import java.time.LocalDateTime;

public record EnrollmentResponseDto(
Long userId,
        Long courseId,
        String userFullName,
        String courseTitle,
        LocalDateTime enrolledAt
) {
}
