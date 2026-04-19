package learn.onlinelearningplatform.mapper;

import learn.onlinelearningplatform.Entity.Lecture;
import learn.onlinelearningplatform.dto.lecture.LectureResponseDto;
import learn.onlinelearningplatform.dto.lecture.LectureCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    uses = ResourceMapper.class   // Important: uses the ResourceMapper we created earlier
)
public interface LectureMapper {

    @Mapping(target = "sectionId", source = "section.id")
    @Mapping(target = "resource", source = "resource")
    LectureResponseDto toResponseDto(Lecture lecture);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "section", ignore = true)     // set in service
    @Mapping(target = "resource", source = "resource")
    Lecture toEntity(LectureCreateDto dto);
}