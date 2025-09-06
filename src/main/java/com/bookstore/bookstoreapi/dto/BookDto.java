package com.bookstore.bookstoreapi.dto;

public record BookDto(
        String bookId,
        String name,
        double price,
        String author,
        String description
) {}
