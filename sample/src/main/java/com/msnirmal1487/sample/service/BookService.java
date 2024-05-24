package com.msnirmal1487.sample.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.msnirmal1487.sample.model.Book;
import com.msnirmal1487.sample.repo.BookRepo;

@Service
public class BookService {

	private static final Logger LOG = LoggerFactory.getLogger(BookService.class);
	@Autowired
    private BookRepo repo; 
	
	@Cacheable(value = "book", unless = "#result==null" )
	public Book findById(int id) {
		
		LOG.info("Find Book By ID " + id);
		
		Optional<Book> optBook = repo.findById(id);
	
		if (!optBook.isPresent()) {
			return null;
		}
		return optBook.get();
	}
}
