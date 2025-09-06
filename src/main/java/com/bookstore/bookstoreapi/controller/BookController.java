package com.bookstore.bookstoreapi.controller;

import com.bookstore.bookstoreapi.dto.BookDto;
import com.bookstore.bookstoreapi.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // constructor injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable String id) {
        return bookService.getBook(id);
    }

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @PutMapping("/{id}")
    public BookDto updateBookName(@PathVariable String id, @RequestBody BookDto bookDto) {
        // ensure path id is applied
        return bookService.updateBookName(new BookDto(id, bookDto.name(), bookDto.price(),
                bookDto.author(), bookDto.description()));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBookByBookId(id);
    }
}
