package learn.onlinelearningplatform.dto.enrollment;

public record EnrollmentCreateDto(
        Long userId,
        Long courseId
) {
}
