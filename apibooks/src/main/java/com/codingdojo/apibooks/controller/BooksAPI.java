package com.codingdojo.apibooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.apibooks.entity.Book;
import com.codingdojo.apibooks.service.BookService;

@RequestMapping("/api/books")
@RestController
public class BooksAPI {
	
	@Autowired
	private BookService bookService;

    @RequestMapping()
    public List<Book> index() {
        return bookService.allBooks();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Book create(Book book) {
        return bookService.createBook(book);
    }
    
    @RequestMapping("/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book result = bookService.findBook(id);
        return result;
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, Book book) {
    	Book result = bookService.updateBook(id, book);
    	return result;
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	bookService.deleteBook(id);
    }
}
