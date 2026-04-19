package learn.onlinelearningplatform.dto.resource;

public sealed interface ResourceResponseDto
        permits VideoResourceResponseDto,
        AudioResourceResponseDto,
        PdfResourceResponseDto{
        Long id();
        String name();
        Long size();
        String url();
        String resourceType();

}
