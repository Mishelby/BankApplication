package by.mishelby.bankapplication.mapper;

import by.mishelby.bankapplication.model.dto.UserCreateDTO;
import by.mishelby.bankapplication.model.dto.UserDTO;
import by.mishelby.bankapplication.model.dto.UserUpdatedDTO;
import by.mishelby.bankapplication.model.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserCreateDTO userCreateDTO);

    UserDTO toDTO(User user);

    User userUpdateToUser(UserUpdatedDTO userUpdatedDTO);
}
