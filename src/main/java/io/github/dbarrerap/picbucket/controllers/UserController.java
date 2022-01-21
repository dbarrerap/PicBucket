package io.github.dbarrerap.picbucket.controllers;

import io.github.dbarrerap.picbucket.entities.Role;
import io.github.dbarrerap.picbucket.entities.User;
import io.github.dbarrerap.picbucket.services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/users").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @PostMapping("/roles")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/roles").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/roles/assign")
    public ResponseEntity<?> assignRole(@RequestBody RoleToUserForm form) {
        userService.assignRole(form.getEmail(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm {
    private String email;
    private String roleName;
}
