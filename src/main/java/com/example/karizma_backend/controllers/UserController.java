package com.example.karizma_backend.controllers;

import com.example.karizma_backend.entities.Utilisateur;
import com.example.karizma_backend.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {

        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/all")
    public List<Utilisateur> findAllUsers() {
        return userServiceImpl.findAllUsers();
    }

    @DeleteMapping("/delete/{id_user}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id_user) {
        userServiceImpl.deleteUser(id_user);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewUser(@RequestBody Utilisateur user) {
        userServiceImpl.addNewUser(user);
        return ResponseEntity.ok("User added successfully");
    }


    @PutMapping("/updatePassword/{id_user}")
    public ResponseEntity<String> updateUserPassword(
            @PathVariable Long id_user,
            @RequestParam String mdp) {
        userServiceImpl.updateUserPassword(mdp, id_user);
        return ResponseEntity.ok("User password updated successfully");
    }
}
