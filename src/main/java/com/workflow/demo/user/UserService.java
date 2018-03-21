package com.workflow.demo.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class UserService {

    UserBuilder builder = new UserBuilder();

    public List<User> getUsers() {
        User adam = builder.setId(1).setName("Adam").build();
        User dave = builder.setId(2).setName("Dave").build();
        User jane = builder.setId(3).setName("Jane").build();
        return new ArrayList<>(Arrays.asList(adam,dave,jane));
    }
}
