package com.loginrpmusic.loginrpmusic.repositories;

import com.loginrpmusic.loginrpmusic.models.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
