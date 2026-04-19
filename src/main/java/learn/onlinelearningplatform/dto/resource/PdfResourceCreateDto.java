package learn.onlinelearningplatform.dto.resource;

public record PdfResourceCreateDto(
        String name,
        Long size,
        String url,
        String type
) implements ResourceCreateDto
{}
