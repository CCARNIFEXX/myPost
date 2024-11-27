package com.micro.mypost.users;

import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/user/")
class UserController {

    private final GetUserQuery getUserQuery;


    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handler(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", exception.getMessage()));
    }

    @GetMapping("{nickname}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("nickname") String nickname) {

        Optional<User> user = getUserQuery.getById(nickname);
        return user
                .map(user1 ->
                        ResponseEntity.ok(new UserDTO().setNickname(user.get().getNickname()).setEmail(user.get().getEmail())))
                .orElseThrow(() -> new UserNotFoundException("Не найден пользователь с nickname = %s ".formatted(nickname)));


    }
}

@Data
@Accessors(chain = true)
class UserDTO {
    @Min(0)
    private String nickname;
    private String email;
}

