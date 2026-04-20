package learn.onlinelearningplatform.Service;

import learn.onlinelearningplatform.Entity.User;
import learn.onlinelearningplatform.dto.user.UserCreateDto;
import learn.onlinelearningplatform.dto.user.UserResponseDto;
import learn.onlinelearningplatform.mapper.UserMapper;
import learn.onlinelearningplatform.repositories.UserRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepositories userRepositories;
    private final UserMapper userMapper;

    public UserResponseDto createUser(
            UserCreateDto dto
    ){
        User user = userMapper.toEntity(dto);
        return userMapper.toResponseDto(userRepositories.save(user));
    }

}
