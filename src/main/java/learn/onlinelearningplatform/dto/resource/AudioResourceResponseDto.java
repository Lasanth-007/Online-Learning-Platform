package learn.onlinelearningplatform.dto.resource;

public record AudioResourceResponseDto(
        Long id,
        String name,
        Long size,
        String url,
        String resourceType,
        String audioFormat
) {
}
