package com.noticias.noticiasV1.repository;

import com.noticias.noticiasV1.models.Resource;
import org.springframework.data.repository.CrudRepository;

public interface ResourceRepository extends CrudRepository<Resource, Integer> {
}
