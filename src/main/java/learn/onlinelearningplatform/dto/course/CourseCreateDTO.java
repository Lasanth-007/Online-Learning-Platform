package learn.onlinelearningplatform.dto.course;

public record CourseCreateDTO(
        String title,
        String description,
        Double price,
        Long instructorId
) {
}
