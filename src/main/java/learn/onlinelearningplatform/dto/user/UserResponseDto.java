package learn.onlinelearningplatform.dto.user;

import learn.onlinelearningplatform.Entity.Role;

public record UserResponseDto(
        String fullName,
        String email,
        String password,
        Role role
) {
}
