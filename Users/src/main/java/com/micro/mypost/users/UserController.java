package com.micro.mypost.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/user/")
class UserController {

    private final GetUserQuery getUserQuery;

    @GetMapping("{userId}")

    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") @NotBlank @NotNull String userId) {
        User user = getUserQuery.getById(userId);
        return ResponseEntity.ok(new UserDTO().setNickname(user.getNickname()).setEmail(user.getEmail()));

    }
}

@Data
@Accessors(chain = true)
class UserDTO {
    private String nickname;
    private String email;
}
