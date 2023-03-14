package com.luxkapotter.Api.Mongo.entities;

public record UserResponseDTO(String id, String name, String email) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getEmail());
    }
}
