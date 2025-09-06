package com.bookstore.bookstoreapi.service;

import com.bookstore.bookstoreapi.dto.BookDto;
import java.util.List;

public interface BookService {
    BookDto getBook(String bookId);
    List<BookDto> getAllBooks();
    BookDto createBook(BookDto bookDto);
    BookDto updateBookName(BookDto bookDto);
    void deleteBookByBookId(String bookId);
}
