package learn.onlinelearningplatform.dto.section;

import com.fasterxml.jackson.annotation.JsonInclude;

public record SectionPatchDto(
        String title,
        Integer orderNumber
) {}
