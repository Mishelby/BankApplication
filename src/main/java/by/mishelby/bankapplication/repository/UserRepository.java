package by.mishelby.bankapplication.repository;

import by.mishelby.bankapplication.model.dto.UserCreateDTO;
import by.mishelby.bankapplication.model.dto.UserUpdatedDTO;
import by.mishelby.bankapplication.model.user.User;

import java.util.Collection;
import java.util.List;

public interface UserRepository  {
    Collection<User> findAll();

    User findById(Long id);

    User create(UserCreateDTO userCreateDTO);

    User update(Long id, UserUpdatedDTO userUpdatedDTO);

    void delete(Long id);
}
