package com.user.registration.services;

import java.util.Collection;

import com.user.registration.models.Users;

public interface UserService {

    Collection<Users> findAll();

    Users findOne(Long id);

    Users create(Users users);

    void delete(Long id);

}
