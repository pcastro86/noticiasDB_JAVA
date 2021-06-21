package com.noticias.noticiasV1.models.responses;

import com.noticias.noticiasV1.models.Canal;
import lombok.Data;

import java.util.Optional;

@Data
public class CanalResponse {
    private int code;
    private String message;
    private Canal canal;
}
