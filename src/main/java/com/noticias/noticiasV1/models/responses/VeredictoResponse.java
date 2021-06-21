package com.noticias.noticiasV1.models.responses;

import com.noticias.noticiasV1.models.Veredicto;
import lombok.Data;

@Data
public class VeredictoResponse {
    private int code;
    private String message;
    private Veredicto veredicto;
}
