package com.user.registration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.registration.models.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
}
