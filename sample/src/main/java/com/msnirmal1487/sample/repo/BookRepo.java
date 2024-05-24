package com.msnirmal1487.sample.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.msnirmal1487.sample.model.Book;

public interface BookRepo extends MongoRepository<Book, Integer>{

	
	@Cacheable(value = "allBooks", unless = "#result==null" )
	List<Book> findAll();
	
	Optional<Book> findById(int id);
}
