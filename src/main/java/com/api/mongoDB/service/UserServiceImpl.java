package com.api.mongoDB.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.mongoDB.model.UserModelRequest;
import com.api.mongoDB.model.UserModelResponse;
import com.api.mongoDB.persistence.entity.UserEntity;
import com.api.mongoDB.persistence.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserModelResponse create(UserModelRequest userModelRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userModelRequest.getNome());
        userEntity.setSenha(userModelRequest.getSenha());
        
        repository.save(userEntity); 
        return createResponse(userEntity);
    }

    private UserModelResponse createResponse(UserEntity userEntity) {
        UserModelResponse userModelResponse = new UserModelResponse();
        userModelResponse.setId(userEntity.getId());
        userModelResponse.setName(userEntity.getName());
        userModelResponse.setSenha(userEntity.getSenha());

        return userModelResponse;
    }

    @Override
    public List<UserModelResponse> getAll() {
        List<UserModelResponse> responses = new ArrayList<>();
        List<UserEntity> user = repository.findAll();

        if(!user.isEmpty()){
            user.forEach(userEntity -> responses.add(createResponse(userEntity)));
        }
        return responses;
    }

    @Override
    public UserModelResponse update(UserModelResponse userModelResponse) {
        UserEntity userEntity = repository.findById(userModelResponse.getId()).get();
        userEntity.setName(userModelResponse.getName());
        userEntity.setSenha(userModelResponse.getSenha());
        repository.save(userEntity);

        return createResponse(userEntity);
    }

    @Override
    public String delet(String Id) {
        repository.deleteById(Id);
        return Id + " foi deletado";
    }


}