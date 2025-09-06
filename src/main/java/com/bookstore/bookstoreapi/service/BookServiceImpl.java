package com.bookstore.bookstoreapi.service;

import com.bookstore.bookstoreapi.dto.BookDto;
import com.bookstore.bookstoreapi.entity.Book;
import com.bookstore.bookstoreapi.mapper.BookMapper;
import com.bookstore.bookstoreapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    // constructor injection
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto getBook(String bookId) {
        return bookRepository.findById(bookId)
                .map(BookMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = BookMapper.toEntity(bookDto);
        Book savedBook = bookRepository.save(book);
        return BookMapper.toDto(savedBook);
    }

    @Override
    public BookDto updateBookName(BookDto bookDto) {
        return bookRepository.findById(bookDto.bookId())
                .map(existing -> {
                    Book updated = new Book(
                            existing.bookId(),
                            bookDto.name(),      // updated name
                            existing.price(),
                            existing.author(),
                            existing.description()
                    );
                    return BookMapper.toDto(bookRepository.save(updated));
                })
                .orElse(null);
    }

    @Override
    public void deleteBookByBookId(String bookId) {
        bookRepository.deleteById(bookId);
    }
}
