package com.api.mongoDB.model;

public class UserModelResponse {
    
    private String id;
    private String name;
    private String senha;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}