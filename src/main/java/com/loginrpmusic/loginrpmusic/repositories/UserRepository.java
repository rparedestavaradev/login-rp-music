package com.loginrpmusic.loginrpmusic.repositories;

import com.loginrpmusic.loginrpmusic.models.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
