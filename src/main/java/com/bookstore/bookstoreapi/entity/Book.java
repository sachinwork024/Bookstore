package com.bookstore.bookstoreapi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")  // MongoDB collection name
public record Book(
        @Id String bookId,
        String name,
        double price,
        String author,
        String description
) {}
