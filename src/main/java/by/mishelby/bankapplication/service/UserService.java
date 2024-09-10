package by.mishelby.bankapplication.service;

import by.mishelby.bankapplication.model.dto.UserDTO.UserCreateDTO;
import by.mishelby.bankapplication.model.dto.UserDTO.UserUpdatedDTO;
import by.mishelby.bankapplication.model.user.User;

import java.util.Collection;

public interface UserService {
    Collection<User> findAll();

    User findById(int id);

    User create(UserCreateDTO userCreateDTO);

    User update(int id, UserUpdatedDTO userUpdatedDTO);

    void delete(int id);

}
