package com.api.mongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mongoDB.model.UserModelRequest;
import com.api.mongoDB.model.UserModelResponse;
import com.api.mongoDB.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
    
    @Autowired
    public UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserModelResponse> creat(@RequestBody UserModelRequest userModelRequest){
        return ResponseEntity.ok(userService.create(userModelRequest));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserModelResponse>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}