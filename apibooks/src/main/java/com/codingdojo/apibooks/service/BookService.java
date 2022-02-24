package com.codingdojo.apibooks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codingdojo.apibooks.entity.Book;
import com.codingdojo.apibooks.repository.BookRepository;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Page<Book> findAllPageable(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		
		return null; 
	}
	
	@Override
	public Book updateBook(Long id, Book book) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		
		if (optionalBook.isPresent()) {
			Book data = optionalBook.get();
			data.setDescription(book.getDescription());
			data.setLanguage(book.getLanguage());
			data.setNumberOfPages(book.getNumberOfPages());
			data.setTitle(book.getTitle());
			
			return bookRepository.save(data);
		}
		
		return null;
	}
	
	@Override
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		
		if (optionalBook.isPresent()) {
			bookRepository.deleteById(id);			
		}
		
	}
	
	/* Unimplemented */
	
	@Override
	public List<Book> findByDescriptionContaining(String search) {
		return null;
	}

	@Override
	public Long countByTitleContaining(String search) {
		return null;
	}

	@Override
	public Long deleteByTitleStartingWith(String search) {
		return null;
	}

}
