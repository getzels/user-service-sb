package com.thehiretalent.userservice.service;

import com.thehiretalent.userservice.model.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<User> getUsersWithDepartments(Pageable pageable);
}
