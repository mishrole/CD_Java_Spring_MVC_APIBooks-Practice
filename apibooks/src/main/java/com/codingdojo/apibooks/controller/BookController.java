package com.codingdojo.apibooks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.apibooks.entity.Book;
import com.codingdojo.apibooks.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "new";
	}
	
	@RequestMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book result = bookService.findBook(id);
        model.addAttribute("book", result);
        return "edit";
	}
	
    @RequestMapping()
    public String index(Model model) {
    	List<Book> books = bookService.allBooks();
    	model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Book result = bookService.findBook(id);
        model.addAttribute("book", result);
        return "show";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
        	return "new";
        }
        
        bookService.createBook(book);
        return "redirect:/books";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if (result.hasErrors()) {
    		return "edit";
    	}
    	
    	bookService.updateBook(id, book);
    	return "redirect:/books";
    }
}
