package com.app.service;

import java.util.List;

import com.app.entities.Book;

public interface BookService {

	 Book saveBook(Book book);
	 void deleteById(Long id);
	 List<Book> findAllBooks();
}
