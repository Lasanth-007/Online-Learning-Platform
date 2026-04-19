package learn.onlinelearningplatform.dto.resource;

public record VideoResourceCreateDto(
        String name,
        Long size,
        String url,
        Integer seconds,
        String resolution
) implements ResourceCreateDto
{}
