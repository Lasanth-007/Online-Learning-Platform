package learn.onlinelearningplatform.dto.resource;

public record VideoResourceResponseDto(
        Long id,
        String name,
        Long size,
        String url,
        String resourceType,
        Integer seconds,
        String resolution
) implements ResourceResponseDto {
}
