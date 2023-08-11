package com.skr.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.api.model.Book;
import com.skr.api.services.BookService;

@RestController
public class BookController {

	// @RequestMapping(value = "/books", method = RequestMethod.GET)
	// @GetMapping("/books")
	// @ResponseBody
	// public Book getBooks() {
	//
	// Book book = new Book();
	// book.setBookID(123);
	// book.setTitle("Java Tutorial");
	// book.setAuthor("Sekhar");
	//
	// return book;
	// }

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> getBooks() {
		return this.bookService.getAllBooks();
	}

	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") int id) {

		return bookService.getBook(id);
	}

	// controller method for post/create book
	@PostMapping("/books")
	public Book addBook(@RequestBody Book b) {
		return bookService.addBook(b);
	}

	// delete book handler
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {

		this.bookService.deleteBook(bookId);

	}

	// update book handler
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		this.bookService.updateBook(book, bookId);
		return book;
	}
}
