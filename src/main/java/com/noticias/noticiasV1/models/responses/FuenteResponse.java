package com.noticias.noticiasV1.models.responses;

import com.noticias.noticiasV1.models.Fuente;
import lombok.Data;

@Data
public class FuenteResponse {
    private int code;
    private String message;
    private Fuente fuente;
}
