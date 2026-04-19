package learn.onlinelearningplatform.dto.user;

import learn.onlinelearningplatform.Entity.Role;

public record UserCreateDto(
        Long id,
        String fullName,
        String email,
        Role role,
        boolean enabled
) {
}
