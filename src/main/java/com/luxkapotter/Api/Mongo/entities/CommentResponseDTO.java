package com.luxkapotter.Api.Mongo.entities;

import java.util.Date;

public record CommentResponseDTO(String text, Date date, AuthorResponseDTO author) {
}
