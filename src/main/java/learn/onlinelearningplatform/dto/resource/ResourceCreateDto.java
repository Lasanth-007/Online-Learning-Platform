package learn.onlinelearningplatform.dto.resource;

public sealed interface ResourceCreateDto
permits VideoResourceCreateDto, AudioResourceCreateDto,
PdfResourceCreateDto{
    String name();
    Long size();
    String url();
}
