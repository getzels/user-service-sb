package com.thehiretalent.userservice;

import com.thehiretalent.userservice.model.User;
import com.thehiretalent.userservice.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void getUsersWithDepartmentsTest() {

        List<User> usersWithDepartments = userRepository.getUsersWithDepartments(PageRequest.of(0, 2, Sort.unsorted()));
        assertEquals(2, usersWithDepartments.size());

        User user1 = usersWithDepartments.get(0);
        assertEquals(1, user1.getUserId());
        assertEquals("user1", user1.getUserName());
        assertEquals(3, user1.getDepartments().size());

        User user2 = usersWithDepartments.get(1);
        assertEquals(2, user2.getUserId());
        assertEquals("user2", user2.getUserName());
        assertEquals(3, user2.getDepartments().size());

    }

    @Test
    void getUsersWithDepartmentsTest_page6() {

        List<User> usersWithDepartments = userRepository.getUsersWithDepartments(PageRequest.of(0, 6, Sort.unsorted()));
        assertEquals(6, usersWithDepartments.size());

        User user1 = usersWithDepartments.get(0);
        assertEquals(1, user1.getUserId());
        assertEquals("user1", user1.getUserName());
        assertEquals(3, user1.getDepartments().size());

        User user2 = usersWithDepartments.get(1);
        assertEquals(2, user2.getUserId());
        assertEquals("user2", user2.getUserName());
        assertEquals(3, user2.getDepartments().size());
    }

}
