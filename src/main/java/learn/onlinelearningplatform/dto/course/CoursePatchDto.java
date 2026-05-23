package learn.onlinelearningplatform.dto.course;

import com.fasterxml.jackson.annotation.JsonInclude;

public record CoursePatchDto(
        String title,
        String description,
        Double price,
        Long instructorId
) {}
