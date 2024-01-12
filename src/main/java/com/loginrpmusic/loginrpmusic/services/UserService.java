package com.loginrpmusic.loginrpmusic.services;

import com.loginrpmusic.loginrpmusic.models.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUser();
    Optional<User> byUId(Long Id);
    User login(User user);
    void deleteUser(Long id);
    void register(User user);
}
