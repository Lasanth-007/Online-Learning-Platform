package learn.onlinelearningplatform.dto.user;

import learn.onlinelearningplatform.Entity.Role;

public record UserCreateDto(
        String fullName,
        String email,
        Role role,
        boolean enabled
) {
}
