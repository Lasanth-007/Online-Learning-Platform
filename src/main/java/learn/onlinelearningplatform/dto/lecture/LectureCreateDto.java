package learn.onlinelearningplatform.dto.lecture;

import learn.onlinelearningplatform.dto.resource.ResourceCreateDto;

public record LectureCreateDto(
        String title,
        Integer durationInMinutes,
        Long sectionId,
        ResourceCreateDto resource
) {
}
