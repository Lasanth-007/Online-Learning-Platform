package learn.onlinelearningplatform.dto.course;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CoursePatchDto(
        String title,
        String description,
        Double price,
        Long instructorId
) {}
