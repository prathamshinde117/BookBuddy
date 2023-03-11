package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Book;
import com.app.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book saveBook(Book book) {
		
		book.setCreateTime(LocalDate.now());
		return bookRepository.save(book);
	}
	
	@Override
	public void deleteById(Long id) {
		
		bookRepository.deleteById(id);
	}
	
	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}
}
