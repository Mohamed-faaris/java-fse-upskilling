package com.example.librarymanagement.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {
    BookService bookService;

    BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public Book[] getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        System.out.println("Received request to add book with title: " +book);
        bookService.addBook(book);
        System.out.println("Adding book: " + book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
