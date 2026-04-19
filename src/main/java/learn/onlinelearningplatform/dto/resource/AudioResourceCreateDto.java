package learn.onlinelearningplatform.dto.resource;

public record AudioResourceCreateDto(
        String name,
        Long size,
        String url,
        String audioFormat
) implements ResourceCreateDto
{}
