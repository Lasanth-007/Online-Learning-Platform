package learn.onlinelearningplatform.dto.lecture;
import com.fasterxml.jackson.annotation.JsonInclude;
import learn.onlinelearningplatform.dto.resource.ResourceResponseDto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LectureResponseDto(
        Long id,
        String title,
        Integer durationInMinutes,
        Long sectionId,
        ResourceResponseDto resource
) {
}
