package com.ginying.memovocab.repository;

import com.ginying.memovocab.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {
    public UserModel findByName(String name);
}
