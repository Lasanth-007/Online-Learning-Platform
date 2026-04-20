package learn.onlinelearningplatform.mapper;

import learn.onlinelearningplatform.Entity.User;
import learn.onlinelearningplatform.dto.user.UserCreateDto;
import learn.onlinelearningplatform.dto.user.UserPatchDto;
import learn.onlinelearningplatform.dto.user.UserResponseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    UserResponseDto toResponseDto(User user);

    List<UserResponseDto> toResponseDtoList(List<User> users);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserCreateDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void patchUser(UserPatchDto dto, @MappingTarget User user);


    void updateUser(UserCreateDto dto,@MappingTarget User user);
}
