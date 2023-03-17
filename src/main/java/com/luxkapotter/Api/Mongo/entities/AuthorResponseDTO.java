package com.luxkapotter.Api.Mongo.entities;

public record AuthorResponseDTO(String id, String name) {
    public AuthorResponseDTO(User user){
        this(user.getId(), user.getName());
    }
}
