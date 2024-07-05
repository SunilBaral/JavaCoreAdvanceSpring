package com.api.rest.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.book.entities.Book;
import com.api.rest.book.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	
	//get all books
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		
		return this.bookService.getAllBooks();
	}
	
	//get single books
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id)
	{
		return bookService.getBookById(id);
	}
	
	//create a book
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{
		Book b = this.bookService.addBoook(book);
		return b;
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId)
	{
		this.bookService.deleteBoook(bookId);
	}
	
	//updste a book
	@PutMapping("/books/{bookId}")
	public void updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId)
	{
		this.bookService.updateBook(book,bookId);
	}
	
}
