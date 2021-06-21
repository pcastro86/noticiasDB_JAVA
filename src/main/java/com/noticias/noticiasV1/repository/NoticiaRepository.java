package com.noticias.noticiasV1.repository;

import com.noticias.noticiasV1.models.Noticia;
import org.springframework.data.repository.CrudRepository;

public interface NoticiaRepository extends CrudRepository<Noticia, Integer> {
}
