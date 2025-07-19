package com.example.memovocab.repository;

import com.example.memovocab.entity.AuthUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends CrudRepository<AuthUser, Long> {

    Optional<AuthUser> findByUsername(String username);
}
