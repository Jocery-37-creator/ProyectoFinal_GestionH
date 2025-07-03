package com.hotel.controller.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAuthDTO {
    private String nombreUsuario;
    private String contrasena;
}