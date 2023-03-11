package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Book;
import com.app.service.BookService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/book")
public class BookController {

	@Autowired
	public BookService bookService;
	
	@PostMapping
	public ResponseEntity<?> saveBook(@RequestBody Book book){
		return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable Long bookId ){
		bookService.deleteById(bookId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllBooks(){
		return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK);
	}
}
