package com.api.mongoDB.controller;

import java.util.List;

import com.api.mongoDB.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.mongoDB.model.UserModelRequest;
import com.api.mongoDB.model.UserModelResponse;
import com.api.mongoDB.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
    
    @Autowired
    public UserService userService;
    public UserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity<UserModelResponse> creat(@RequestBody UserModelRequest userModelRequest){
        return ResponseEntity.ok(userService.create(userModelRequest));
    }

    @GetMapping()
    public ResponseEntity<List<UserModelResponse>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping
    public UserModelResponse update(@RequestBody UserModelResponse userModelResponse){
        return userService.update(userModelResponse);
    }

    @DeleteMapping("/{id}")
    public String delet(@PathVariable("id") String Id){
        return userService.delet(Id);
    }
}