package com.workflow.demo.user;

public class UserBuilder {

    private User user;

    public UserBuilder() {
        user = new User();
    }

    public UserBuilder setId(Integer id) {
        user.setId(id);
        return this;
    }

    public UserBuilder setName(String name) {
        user.setName(name);
        return this;
    }

    public User build() {
        User userToReturn = this.user;
        user = new User();
        return userToReturn;
    }

}
