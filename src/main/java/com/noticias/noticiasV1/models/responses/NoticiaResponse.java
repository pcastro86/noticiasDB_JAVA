package com.noticias.noticiasV1.models.responses;

import com.noticias.noticiasV1.models.Noticia;
import lombok.Data;

@Data
public class NoticiaResponse {
    private int code;
    private String message;
    private Noticia noticia;
}
