package com.api.rest.book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.rest.book.dao.BookRepository;
import com.api.rest.book.entities.Book;

import jakarta.persistence.EntityNotFoundException;

@Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;
//	private static List<Book> list=new ArrayList();
//	
//	static {
//		list.add(new Book(12,"java complete reference","xyz"));
//		list.add(new Book(13,"Head first to java","abc"));
//		list.add(new Book(14,"thing in java","lmn"));
//		
//	}

	// get all books
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	// get single book by id
	public Book getBookById(int id) {
		// Book book = list.stream().filter(e->e.getId()==id).findFirst().get();
		Book book = this.bookRepository.findById(id);
		return book;
	}

	// adding the book
	public Book addBoook(Book b) {
		// list.add(b);
		Book result = bookRepository.save(b);
		return result;
	}

	// delete book
	public void deleteBoook(int bid) {
		bookRepository.deleteById(bid);
		// list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
//		list.stream().filter(book->{
//			if(book.getId()!=bid)
//			{
//				return true;
//			}else {
//				return false;
//			}
//		}).collect(Collectors.toList());
	}

	// update book
	public void updateBook(Book book, int bookId) {
		  Book existingBook = bookRepository.findById(bookId);
		    
		    // Check if the book exists in the database
		    if (existingBook != null) {
		        // Update the existing book entity with the new data
		        existingBook.setTitle(book.getTitle());
		        existingBook.setAuthor(book.getAuthor());
		        // Add more properties to update as needed
		        
		        try {
		            // Save the updated book entity back to the database
		            bookRepository.save(existingBook);
		            // Book updated successfully, no need to return anything
		        } catch (Exception e) {
		            // Handle any exceptions that may occur during the update process
		            // You can log the error message or throw a custom exception
		            // For example:
		            throw new RuntimeException("Failed to update book with ID: " + bookId, e);
		        }
		    } else {
		        // Handle the case where the book with the specified ID does not exist
		        // For example:
		        throw new EntityNotFoundException("Book not found with ID: " + bookId);
		    }
//		list=list.stream().map(b->{
//			if(b.getId()==bookId)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
	}
}
