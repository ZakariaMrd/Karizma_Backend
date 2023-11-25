package com.example.karizma_backend.service.impl;

import com.example.karizma_backend.entities.Utilisateur;
import com.example.karizma_backend.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private final UtilisateurRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public List<Utilisateur> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id_user) {
        userRepository.deleteById(id_user);
    }

    public void addNewUser(Utilisateur user) {
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bcryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

    public void updateUserPassword(String mdp, Long id_user) {
        Utilisateur user = userRepository.findById(id_user)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id_user));
        user.setPassword(mdp);
        userRepository.save(user);
    }
}
