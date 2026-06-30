package org.library.service;

import java.util.List;

import org.library.model.BookModel;
import org.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
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