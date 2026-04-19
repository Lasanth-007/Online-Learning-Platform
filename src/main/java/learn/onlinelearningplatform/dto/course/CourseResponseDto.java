package learn.onlinelearningplatform.dto.course;

public record CourseResponseDto(

        Long id,
        String title,
        String description,
        Double price,
        String instructorName,        // convenient field
        Long instructorId
) {}
