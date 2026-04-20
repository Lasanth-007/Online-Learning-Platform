package learn.onlinelearningplatform.mapper;

import learn.onlinelearningplatform.Entity.Section;
import learn.onlinelearningplatform.dto.section.SectionCreateDto;
import learn.onlinelearningplatform.dto.section.SectionResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SectionMapper {

    @Mapping(target = "courseId", source = "course.id")
    SectionResponseDto toResponseDto(Section section);

    List<SectionResponseDto> toResponseDtoList(List<Section> sections);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "course", ignore = true)
    Section toEntity(SectionCreateDto dto);
}