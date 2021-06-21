package com.noticias.noticiasV1.repository;

import com.noticias.noticiasV1.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
