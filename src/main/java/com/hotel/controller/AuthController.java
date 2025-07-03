package com.hotel.controller;

//import com.acm.advices.controller.dto.UserAuthDTO;
import com.hotel.controller.DTO.UserAuth;
//import com.acm.advices.controller.dto.UserDTO;
import com.hotel.model.Usuario;
//import com.acm.advices.persistence.entity.UserEntity;

//import com.acm.advices.service.IUserService;
import com.hotel.service.UsuarioService;
//import com.acm.advices.service.impl.UserServiceImpl;
//import com.acm.advices.util.JwtUtil;
import com.hotel.util.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UsuarioService userService;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserAuth userAuth){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuth.getNombreUsuario(), userAuth.getContrasena())
            );
            User user = (User) authentication.getPrincipal();
            String token = jwtUtil.generateToken(user.getUsername());
            Map<String,Object> respone = new HashMap<>();
            respone.put("token",token);
            respone.put("username", user.getUsername());
            return ResponseEntity.ok(respone);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> sigUp(@Valid @RequestBody Usuario usuario){
        try{
            userService.save(com.hotel.model.Usuario.builder()
                    .idUsuario(usuario.getIdUsuario())
                    .nombreUsuario(usuario.getNombreUsuario())
                    .contrasena(passwordEncoder.encode(usuario.getContrasena()))
                    .rol(usuario.getRol())
                    .build());
            return ResponseEntity.ok("User created successfully");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}