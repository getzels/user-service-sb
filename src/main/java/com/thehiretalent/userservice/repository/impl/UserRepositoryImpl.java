package com.thehiretalent.userservice.repository.impl;

import com.thehiretalent.userservice.model.Department;
import com.thehiretalent.userservice.model.User;
import com.thehiretalent.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private JdbcTemplate jdbcTemplate;

    public List<User> getUsersWithDepartments(Pageable pageable) {
        String sql = "SELECT u.user_id, " +
                "            u.user_name, " +
                "            d.department_id, " +
                "            d.department_name " +
                "FROM test_db.\"user\" u " +
                "JOIN test_db.department_user du ON u.user_id = du.user_id " +
                "JOIN test_db.department d ON d.department_id = du.department_id " +
                "WHERE u.user_id in (SELECT eu.user_id " +
                "               FROM test_db.\"user\" eu " +
                "               LIMIT ? " +
                "               OFFSET ?)"
                ;

        return jdbcTemplate.query(sql,
                new Object[]{pageable.getPageSize(), pageable.getOffset()},
                        (rs, rowNum) -> {
                    Long userId = rs.getLong("user_id");
                    String userName = rs.getString("user_name");
                    Long departmentId = rs.getLong("department_id");
                    String departmentName = rs.getString("department_name");

                    User user = new User(userId, userName);
                    user.getDepartments().add(new Department(departmentId, departmentName));
                    return user;
                })
                .stream()
                .collect(Collectors.groupingBy(User::getUserId))
                .values()
                .stream()
                .map(usersWithSameId -> {
                    User user = usersWithSameId.get(0);
                    usersWithSameId.stream()
                            .skip(1)
                            .forEach(user::addDepartment);
                    return user;
                })
                .collect(Collectors.toList());
    }


}
