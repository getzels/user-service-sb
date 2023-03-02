package com.thehiretalent.userservice.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;
    private String userName;
    private List<Department> departments = new ArrayList<>();

    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public void addDepartment(User user) {
        departments.addAll(user.getDepartments());
    }
}
