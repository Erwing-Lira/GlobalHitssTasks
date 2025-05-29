package com.elira.taskManager.controller;

import com.elira.taskManager.entities.User;
import com.elira.taskManager.service.IUserService;
import com.elira.taskManager.utils.ValidationErrors;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;
    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> createUser(
            @Valid @RequestBody User user,
            BindingResult result
    ) {
        if (result.hasFieldErrors()) {
            return ValidationErrors.validation(result);
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.save(user));
    }
}
