package com.noticias.noticiasV1.models.responses;

import com.noticias.noticiasV1.models.Partido;
import lombok.Data;

@Data
public class PartidoResponse {
    private int code;
    private String message;
    private Partido partido;
}
