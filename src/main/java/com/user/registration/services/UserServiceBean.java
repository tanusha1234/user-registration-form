package com.user.registration.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.registration.models.Users;
import com.user.registration.repositories.UserRepository;

@Service
public class UserServiceBean implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<Users> findAll() {

        Collection<Users> users = userRepository.findAll();

        return users;
    }

    @Override
    public Users findOne(Long id) {

        Users users = userRepository.findOne(id);

        return users;
    }

    @Override
    public Users create(Users users) {

        Users savedUser = userRepository.save(users);

        return savedUser;
    }

    @Override
    public void delete(Long id) {

        userRepository.delete(id);

    }

}
