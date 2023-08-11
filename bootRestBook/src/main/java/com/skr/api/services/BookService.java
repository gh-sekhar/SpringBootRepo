package com.skr.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.skr.api.model.Book;

@Component
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(11, "python", "pitter"));
		list.add(new Book(12, "java", "skr"));
		list.add(new Book(13, "React", "smn"));
	}

	// get all books

	public List<Book> getAllBooks() {

		return list;
	}

	// get single book by id
	public Book getBook(int id) {
		Book book = null;
		book = list.stream().filter(e -> e.getBookID() == id).findFirst().get();
		return book;
	}

	// adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	// delete a book
	public void deleteBook(int id) {

		list = list.stream().filter(e -> e.getBookID() != id).collect(Collectors.toList());

	}

	// update a book
	public void updateBook(Book book, int bookId) {

		list = list.stream().map(bk -> {
			if (bk.getBookID() == bookId) {
				bk.setAuthor(book.getAuthor());
				bk.setTitle(book.getTitle());
			}
			return bk;
		}).collect(Collectors.toList());

	}

}
