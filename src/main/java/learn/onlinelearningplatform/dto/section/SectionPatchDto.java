package learn.onlinelearningplatform.dto.section;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SectionPatchDto(
        String title,
        Integer orderNumber
) {}
