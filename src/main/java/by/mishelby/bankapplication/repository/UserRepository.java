package by.mishelby.bankapplication.repository;

import by.mishelby.bankapplication.model.dto.UserDTO.UserCreateDTO;
import by.mishelby.bankapplication.model.dto.UserDTO.UserUpdatedDTO;
import by.mishelby.bankapplication.model.user.User;

import java.util.Collection;

public interface UserRepository  {
    Collection<User> findAll();

    User findById(Long id);

    User save(UserCreateDTO userCreateDTO);

    User update(Long id, UserUpdatedDTO userUpdatedDTO);

    void delete(Long id);
}
