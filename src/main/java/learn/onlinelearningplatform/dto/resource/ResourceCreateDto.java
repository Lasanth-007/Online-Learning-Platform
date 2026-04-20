package learn.onlinelearningplatform.dto.resource;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/*@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "resourceType"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = VideoResourceCreateDto.class, name = "VIDEO"),
    @JsonSubTypes.Type(value = AudioResourceCreateDto.class, name = "AUDIO"),
    @JsonSubTypes.Type(value = PdfResourceCreateDto.class, name = "PDF")
})*/
public sealed interface ResourceCreateDto
permits VideoResourceCreateDto, AudioResourceCreateDto,
PdfResourceCreateDto{
    String name();
    Long size();
    String url();
}
