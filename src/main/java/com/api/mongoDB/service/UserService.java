package com.api.mongoDB.service;

import java.util.List;

import com.api.mongoDB.model.UserModelRequest;
import com.api.mongoDB.model.UserModelResponse;

public interface UserService {
 
    UserModelResponse create(UserModelRequest userModelRequest);

    List<UserModelResponse> getAll();

    UserModelResponse update(UserModelResponse userModelResponse);

    String delet(String Id);
}