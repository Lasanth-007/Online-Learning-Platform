package learn.onlinelearningplatform.dto.resource;

public record PdfResourceResponseDto(
        Long id,
        String name,
        Long size,
        String url,
        String resourceType,
        String type
) {
}
