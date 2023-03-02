package com.thehiretalent.userservice.repository;

import com.thehiretalent.userservice.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository {

    List<User> getUsersWithDepartments(Pageable pageable);
}
