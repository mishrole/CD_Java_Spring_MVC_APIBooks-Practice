package com.codingdojo.apibooks.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.codingdojo.apibooks.entity.Book;

public interface IBookService {
	public abstract List<Book> allBooks();
	public abstract Book createBook(Book book);
	public abstract Book findBook(Long id);
	public abstract Book updateBook(Long id, Book book);
	public abstract void deleteBook(Long id);
	
	public abstract List<Book> findByDescriptionContaining(String search);
	public abstract Long countByTitleContaining(String search);
	public abstract Long deleteByTitleStartingWith(String search);
	public Page<Book> findAllPageable(Pageable pageable);
}
