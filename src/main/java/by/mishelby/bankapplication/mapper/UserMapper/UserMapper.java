package by.mishelby.bankapplication.mapper.UserMapper;

import by.mishelby.bankapplication.model.dto.UserDTO.UserCreateDTO;
import by.mishelby.bankapplication.model.dto.UserDTO.UserDTO;
import by.mishelby.bankapplication.model.dto.UserDTO.UserUpdatedDTO;
import by.mishelby.bankapplication.model.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreateDTO userCreateDTO);

    UserDTO toDTO(User user);

    User userUpdateToUser(UserUpdatedDTO userUpdatedDTO);
}
