package com.loginrpmusic.loginrpmusic.services;

import com.loginrpmusic.loginrpmusic.models.entity.User;
import com.loginrpmusic.loginrpmusic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUser() {
        return (List<User>)repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> byUId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public User login(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void register(User user) {

    }
}
