package learn.onlinelearningplatform.dto.resource;

public record ResourceResponseDto(
        Long id,
        String name,
        Long size,
        String url,
        String resourceType
) {
}
