package by.mishelby.bankapplication.controller.rest;

import by.mishelby.bankapplication.mapper.UserMapper;
import by.mishelby.bankapplication.model.dto.UserCreateDTO;
import by.mishelby.bankapplication.model.dto.UserDTO;
import by.mishelby.bankapplication.model.dto.UserUpdatedDTO;
import by.mishelby.bankapplication.model.user.User;
import by.mishelby.bankapplication.repository.UserRepositoryImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@Slf4j
@RestController("userRestController")
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserRepositoryImpl userRepository;
    private final UserMapper userMapper;

    @GetMapping("/users")
    public Iterable<UserDTO> getAllUsers() {
        Collection<User> userList = userRepository.findAll();
        return userList
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        var user = userRepository.findById(id);
        return userMapper.toDTO(user);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserCreateDTO userCreateDTO) {

        var user = userRepository.create(userCreateDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(
                userMapper.toDTO(user)
        );
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id,
                                              @Valid @RequestBody UserUpdatedDTO userUpdatedDTO) {
        var updateUser = userRepository.update(id, userUpdatedDTO);
        return ResponseEntity.ok().body(
                userMapper.toDTO(updateUser)
        );
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userRepository.delete(id);
        return ResponseEntity.noContent().build();
    }
}
