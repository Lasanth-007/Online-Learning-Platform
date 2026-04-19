package learn.onlinelearningplatform.dto.course;

public record CourseCreateDto(
        String title,
        String description,
        Double price,
        Long instructorId
) {
}
