package by.mishelby.bankapplication.repository;

import by.mishelby.bankapplication.mapper.UserMapper.UserMapper;
import by.mishelby.bankapplication.mapper.UserMapper.UserMapperClass;
import by.mishelby.bankapplication.model.dto.UserDTO.UserCreateDTO;
import by.mishelby.bankapplication.model.dto.UserDTO.UserUpdatedDTO;
import by.mishelby.bankapplication.model.user.User;
import by.mishelby.bankapplication.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Collection;


@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final UserMapper userMapper;
    private final KeyHolder keyHolder;

    @Override
    @Transactional(readOnly = true)
    public Collection<User> findAll() {
        var sql = "SELECT u.user_id, u.first_name, u.middle_name, u.last_name, u.birth_date, ba.account_id, ba.balance " +
                "FROM bank_repository.users u LEFT JOIN bank_repository.bank_account ba ON ba.owner_id = u.user_id";
        return jdbcTemplate.query(sql, new UserMapperClass());
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        var sql = "SELECT u.user_id, u.first_name, u.middle_name, u.last_name, u.birth_date, ba.account_id, ba.balance " +
                "FROM bank_repository.users u LEFT JOIN bank_repository.bank_account ba ON ba.owner_id = u.user_id " +
                "WHERE u.user_id = :id";

        var params = new MapSqlParameterSource()
                .addValue("id", id);

        return namedParameterJdbcTemplate.query(sql, params, new UserMapperClass())
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
    }

    @Override
    @Transactional
    public User save(UserCreateDTO userCreateDTO) {
        var sql = "INSERT INTO bank_repository.users (first_name, middle_name, last_name, birth_date) values (:firstName, :middleName, :lastName, :birthDate)";

        var params = getMapSqlParameterSource(userCreateDTO);

        namedParameterJdbcTemplate.update(sql, params, keyHolder, new String[]{"user_id"});

        var key = keyHolder.getKey();
        if (key == null) {
            throw new RuntimeException("Failed to get generated key");
        }

        var user = userMapper.toEntity(userCreateDTO);
        user.setId(key.longValue());

        return user;
    }


    @Override
    @Transactional
    public User update(Long id, UserUpdatedDTO userUpdatedDTO) {
        var user = findById(id);
        var sql = "UPDATE bank_repository.users SET first_name = :firstName, middle_name = :middleName, last_name = :lastName, birth_date = :birthDate  WHERE user_id = :id";

        var params = getMapSqlParameterSource(id, userUpdatedDTO);

        int update = namedParameterJdbcTemplate.update(sql, params);

        if (update == 0) {
            throw new ResourceNotFoundException("Failed to update user with id: " + id);
        }

        user.setFirstName(userUpdatedDTO.getFirstName());
        user.setMiddleName(userUpdatedDTO.getMiddleName());
        user.setLastName(userUpdatedDTO.getLastName());
        user.setBirthDate(userUpdatedDTO.getBirthDate());

        return user;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        var sql = "DELETE FROM bank_repository.users WHERE user_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static MapSqlParameterSource getMapSqlParameterSource(Long id, UserUpdatedDTO userUpdatedDTO) {
        var params = new MapSqlParameterSource()
                .addValue("firstName", userUpdatedDTO.getFirstName())
                .addValue("middleName", userUpdatedDTO.getMiddleName())
                .addValue("lastName", userUpdatedDTO.getLastName())
                .addValue("birthDate", userUpdatedDTO.getBirthDate())
                .addValue("id", id);
        return params;
    }

    private static MapSqlParameterSource getMapSqlParameterSource(UserCreateDTO userCreateDTO) {
        var params = new MapSqlParameterSource()
                .addValue("firstName", userCreateDTO.getFirstName())
                .addValue("middleName", userCreateDTO.getMiddleName())
                .addValue("lastName", userCreateDTO.getLastName())
                .addValue("birthDate", userCreateDTO.getBirthDate());
        return params;
    }
}
