package com.api.rest.book.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.rest.book.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer>{
	
	public Book findById(int id);

}
