package com.codingdojo.apibooks.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.apibooks.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    // Recupera todos los libros de la base de datos
    List<Book> findAll();
    // Encuentra libros con descripciones que contienen la cadena de búsqueda
    List<Book> findByDescriptionContaining(String search);
    // Cuenta cuántos títulos contienen una determinada cadena
    Long countByTitleContaining(String search);
    // Elimina un libro que comienza con un título específico
    Long deleteByTitleStartingWith(String search);
    // Lista todos los libros con paginado
    Page<Book> findAll(Pageable pageable);
}
