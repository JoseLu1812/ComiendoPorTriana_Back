package com.salesianos.triana.ComiendoPorTriana.user.controller;

import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import com.salesianos.triana.ComiendoPorTriana.user.model.dto.CreateUserRequest;
import com.salesianos.triana.ComiendoPorTriana.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<User> createUserWithUserRole(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUserWithUserRole(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @PostMapping("/auth/register/admin")
    public ResponseEntity<User> createUserWithAdminRole(@RequestBody CreateUserRequest createUserRequest) {
        User user = userService.createUserWithAdminRole(createUserRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
