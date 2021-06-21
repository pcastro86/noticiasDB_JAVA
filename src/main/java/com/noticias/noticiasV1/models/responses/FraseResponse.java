package com.noticias.noticiasV1.models.responses;


import com.noticias.noticiasV1.models.Frase;
import lombok.Data;

@Data
public class FraseResponse {
    private int code;
    private String message;
    private Frase frase;
}
