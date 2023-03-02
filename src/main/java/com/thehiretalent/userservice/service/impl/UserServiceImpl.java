package com.thehiretalent.userservice.service.impl;

import com.thehiretalent.userservice.model.User;
import com.thehiretalent.userservice.repository.UserRepository;
import com.thehiretalent.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUsersWithDepartments(Pageable pageable) {
        return userRepository.getUsersWithDepartments(pageable);
    }
}
