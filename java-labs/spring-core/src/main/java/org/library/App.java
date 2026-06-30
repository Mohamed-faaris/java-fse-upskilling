package org.library;

import org.library.model.BookModel;
import org.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean(BookService.class);

        BookModel book1 = new BookModel(1, "Book One", "Author One");
        BookModel book2 = new BookModel(2, "Book Two", "Author Two");
        
        bookService.addBook(book1);
        bookService.addBook(book2);

        bookService.getAllBooks().forEach(System.out::println);
    }
}
