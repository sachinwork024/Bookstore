package com.bookstore.bookstoreapi.repository;

import com.bookstore.bookstoreapi.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
