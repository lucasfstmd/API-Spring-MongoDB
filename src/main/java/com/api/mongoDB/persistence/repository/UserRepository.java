package com.api.mongoDB.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.api.mongoDB.persistence.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String>{
    
}