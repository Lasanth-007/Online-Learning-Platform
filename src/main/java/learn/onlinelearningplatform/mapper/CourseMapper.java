package learn.onlinelearningplatform.mapper;

import learn.onlinelearningplatform.Entity.Course;
import learn.onlinelearningplatform.dto.course.CourseCreateDto;
import learn.onlinelearningplatform.dto.course.CoursePatchDto;
import learn.onlinelearningplatform.dto.course.CourseResponseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CourseMapper {
    @Mapping(target = "instructorName", source = "instructor.fullName")
    @Mapping(target = "instructorId", source = "instructor.id")
    CourseResponseDto toResponseDto(Course course);

    List<CourseResponseDto> toResponseDtoList(List<Course> courses);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "instructor", ignore = true)
    Course toEntity(CourseCreateDto dto);

    void updateCourseFromDto(CourseCreateDto dto, @MappingTarget Course course);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "instructor", ignore = true)
    void updateCourseFromPatch(CoursePatchDto dto, @MappingTarget Course course);
}
