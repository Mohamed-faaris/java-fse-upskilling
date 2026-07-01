package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.repository.BookRepository;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    BookRepository bookRepository;
    
    BookService (BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public Book getBook(Long id){
        return bookRepository.findById(id).orElse(null);
    }
    public Book[] getAllBooks(){
        return bookRepository.findAll().toArray(new Book[0]);
    }

    public Book updateBook(Long id, Book updatedBook){
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setIsbn(updatedBook.getIsbn());
            return bookRepository.save(existingBook);
        }
        return null;
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    
}
