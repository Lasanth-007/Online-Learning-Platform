package learn.onlinelearningplatform.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import learn.onlinelearningplatform.Entity.Role;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserPatchDto(
        String fullName,
        String email,
        String password,
        Role role,
        Boolean enabled
) {}
