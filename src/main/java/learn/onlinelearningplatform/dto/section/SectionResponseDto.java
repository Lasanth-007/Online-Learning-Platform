package learn.onlinelearningplatform.dto.section;

public record SectionResponseDto(
        Long id,
        String title,
        Long courseId
) {
}
