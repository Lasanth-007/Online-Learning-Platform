package learn.onlinelearningplatform.dto.enrollment;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EnrollmentResponseDto(
        Long userId,
        Long courseId,
        String userFullName,
        String courseTitle,
        LocalDateTime enrolledAt
) {
}
