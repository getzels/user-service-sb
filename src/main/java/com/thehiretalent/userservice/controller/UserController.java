package com.thehiretalent.userservice.controller;

import com.thehiretalent.userservice.model.User;
import com.thehiretalent.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsersWithDepartments(@PageableDefault(size = 2) Pageable pageable) {

        return userService.getUsersWithDepartments(pageable);
    }
}
