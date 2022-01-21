package io.github.dbarrerap.picbucket.services;

import io.github.dbarrerap.picbucket.entities.Role;
import io.github.dbarrerap.picbucket.entities.User;

import java.util.List;

public interface IUserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void assignRole(String email, String roleName);
    User getUser(String email);
    List<User> getUsers();
}
