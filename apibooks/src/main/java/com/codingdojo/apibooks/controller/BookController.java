package com.codingdojo.apibooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.apibooks.entity.Book;
import com.codingdojo.apibooks.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Book result = bookService.findBook(id);
        model.addAttribute("book", result);
        return "show";
    }
}
