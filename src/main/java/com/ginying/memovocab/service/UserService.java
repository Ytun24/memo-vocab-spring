package com.ginying.memovocab.service;

import com.ginying.memovocab.model.UserModel;

public interface UserService {
    public UserModel findUserByName(String name);
    public UserModel findOne(String id);
}
