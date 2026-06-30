package org.library.repository;

import java.util.ArrayList;
import java.util.List;

import org.library.model.BookModel;

/**
 * BookRepository
 */
public class BookRepository {
    private List<BookModel> books = new ArrayList<>();
    
    public void addBook(BookModel book) {
        books.add(book);
        System.out.println("Book added: " + book.getName());
    }

    public List<BookModel> getAllBooks() {
        return books;
    }

    public BookModel getBookById(int id) {
        for (BookModel book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null; 
    }
    
}