package learn.onlinelearningplatform.dto.lecture;
import learn.onlinelearningplatform.dto.resource.ResourceResponseDto;

public record LectureResponseDto(
        Long id,
        String title,
        Integer durationInMinutes,
        Long sectionId,
        ResourceResponseDto resource
) {
}
