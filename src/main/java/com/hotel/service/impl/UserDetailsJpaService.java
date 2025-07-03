package com.hotel.service.impl;

import com.hotel.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsJpaService implements UserDetailsService {
    private final UsuarioRepository userJpaRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userJpaRepository.findByUsername(username)
                .map(user -> User.builder().username(user.getNombre_usuario()).password(user.getContrasena())
                        .authorities("ROLE_USER").build())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}
