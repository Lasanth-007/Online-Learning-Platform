package learn.onlinelearningplatform.mapper;

import learn.onlinelearningplatform.Entity.Course;
import learn.onlinelearningplatform.dto.course.CourseCreateDto;
import learn.onlinelearningplatform.dto.course.CourseResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import java.util.List;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CourseMapper {
    @Mapping(target = "instructorName", source = "instructor.fullName")
    @Mapping(target = "instructorId", source = "instructor.id")
    CourseResponseDto toResponseDto(Course course);

    List<CourseResponseDto> toResponseDtoList(List<Course> courses);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "instructor", ignore = true)
    Course toEntity(CourseCreateDto dto);
}
