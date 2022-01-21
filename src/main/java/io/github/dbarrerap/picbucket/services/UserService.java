package io.github.dbarrerap.picbucket.services;

import io.github.dbarrerap.picbucket.entities.Role;
import io.github.dbarrerap.picbucket.entities.User;
import io.github.dbarrerap.picbucket.repositories.IRoleRepository;
import io.github.dbarrerap.picbucket.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("* Saving user {}", user.getEmail());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("* Saving role {}", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void assignRole(String email, String roleName) {
        User user = userRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);

        log.info("* Assigning role {} to user {}", role.getName(), user.getEmail());

        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
        log.info("* Searching for user {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        log.info("* Listing all users.");
        return userRepository.findAll();
    }
}
