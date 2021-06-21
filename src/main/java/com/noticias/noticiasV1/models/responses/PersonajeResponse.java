package com.noticias.noticiasV1.models.responses;

import com.noticias.noticiasV1.models.Personaje;
import lombok.Data;

@Data
public class PersonajeResponse {
    private int code;
    private String message;
    private Personaje personaje;
}
