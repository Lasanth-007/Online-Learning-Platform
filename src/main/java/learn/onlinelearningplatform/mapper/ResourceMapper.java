package learn.onlinelearningplatform.mapper;

import learn.onlinelearningplatform.Entity.Audio;
import learn.onlinelearningplatform.Entity.Pdf;
import learn.onlinelearningplatform.Entity.Resource;
import learn.onlinelearningplatform.Entity.Video;
import learn.onlinelearningplatform.dto.resource.*;
import org.mapstruct.*;

import java.util.List;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ResourceMapper {


    VideoResourceResponseDto toVideoResponseDto(Video video);
    AudioResourceResponseDto toAudioResponseDto(Audio audio);
    PdfResourceResponseDto toPdfResponseDto(Pdf pdf);

    @Named("complexResourceMapping")
    default ResourceResponseDto toResponseDto(Resource resource) {
        return switch (resource) {
            case null -> null;
            case Video video -> toVideoResponseDto(video);
            case Audio audio -> toAudioResponseDto(audio);
            case Pdf pdf -> toPdfResponseDto(pdf);
            default -> throw new IllegalStateException("Unexpected value: " + resource);

        };

    }

    // Helper for lists
    default List<ResourceResponseDto> toResponseDtoList(List<Resource> resources) {
        if (resources == null) {
            return null;
        }
        return resources.stream()
                .map(this::toResponseDto)
                .toList();
    }

    // ==================== Polymorphic DTO → Entity ====================
    default Resource toEntity(ResourceCreateDto dto) {
        return switch (dto) {
            case null -> null;
            case VideoResourceCreateDto videoDto -> toVideoEntity(videoDto);
            case AudioResourceCreateDto audioDto -> toAudioEntity(audioDto);
            case PdfResourceCreateDto pdfDto -> toPdfEntity(pdfDto);
            default ->
                    throw new IllegalArgumentException("Unknown ResourceCreateDto type: " + dto.getClass().getSimpleName());
        };

    }

    // ==================== Specific Creation Mappings ====================
    @Mapping(target = "id", ignore = true)
    Video toVideoEntity(VideoResourceCreateDto dto);

    @Mapping(target = "id", ignore = true)
    Audio toAudioEntity(AudioResourceCreateDto dto);

    @Mapping(target = "id", ignore = true)
    Pdf toPdfEntity(PdfResourceCreateDto dto);
}