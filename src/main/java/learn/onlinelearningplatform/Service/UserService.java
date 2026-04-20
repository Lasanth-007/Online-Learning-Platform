package learn.onlinelearningplatform.Service;

import jakarta.transaction.Transactional;
import learn.onlinelearningplatform.Entity.User;
import learn.onlinelearningplatform.dto.user.UserCreateDto;
import learn.onlinelearningplatform.dto.user.UserPatchDto;
import learn.onlinelearningplatform.dto.user.UserResponseDto;
import learn.onlinelearningplatform.mapper.UserMapper;
import learn.onlinelearningplatform.repositories.UserRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepositories userRepositories;
    private final UserMapper userMapper;

   // ==================== CREATE ====================
    @Transactional
    public UserResponseDto createUser(UserCreateDto dto) {

        User user = userMapper.toEntity(dto);
        return userMapper.toResponseDto(userRepositories.save(user));
    }

    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepositories.findAll();
        return userMapper.toResponseDtoList(users);
    }

    public UserResponseDto getUserById(Long id) {
        User user = userRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toResponseDto(user);
    }

    public UserResponseDto getUserByEmail(String email) {
        User user = userRepositories.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toResponseDto(user);
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UserCreateDto dto) {
        User user = userRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUser(dto,user);

        return userMapper.toResponseDto(userRepositories.save(user));
    }

    @Transactional
    public UserResponseDto patchUser(Long id, UserPatchDto dto) {
        User user = userRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.patchUser(dto, user);

        return userMapper.toResponseDto(userRepositories.save(user));
    }


    @Transactional
    public void deleteUser(Long id) {
        if (!userRepositories.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepositories.deleteById(id);
    }
}
