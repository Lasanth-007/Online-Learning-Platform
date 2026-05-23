package learn.onlinelearningplatform.dto.lecture;

import com.fasterxml.jackson.annotation.JsonInclude;


public record LecturePatchDto(
        String title,
        Integer durationInMinutes
) {
}
