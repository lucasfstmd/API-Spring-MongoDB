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

    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable("Id") String Id, @RequestBody UserModelRequest userModelRequest){
        return userRepository.findById(Id).map(record -> {
            record.setName(userModelRequest.getNome());
            record.setSenha(userModelRequest.getSenha());
            UserModelResponse userModelRequestUpdate = userService.create(userModelRequest);
            return ResponseEntity.ok().body(userModelRequestUpdate);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delet(@PathVariable("id") String Id){
        return userRepository.findById(Id).map(record -> {
            userRepository.deleteById(Id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}