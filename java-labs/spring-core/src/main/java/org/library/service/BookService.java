package org.library.service;

import java.util.List;

import org.library.model.BookModel;
import org.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(BookModel book) {
        bookRepository.addBook(book);
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public BookModel getBookById(int id) {
        return bookRepository.getBookById(id);
    }
}