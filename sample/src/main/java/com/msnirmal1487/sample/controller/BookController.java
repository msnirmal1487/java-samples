package com.msnirmal1487.sample.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msnirmal1487.sample.model.Book;
import com.msnirmal1487.sample.model.primary.Department;
import com.msnirmal1487.sample.repo.BookRepo;
import com.msnirmal1487.sample.repo.primary.DepartmentRepository;
import com.msnirmal1487.sample.service.BookService;

@RestController
public class BookController {

	private static final Logger LOG = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
    private BookRepo repo; 
	
	@Autowired
	private BookService service;
	
	@Autowired
    private DepartmentRepository departmentRepository;
  
    @PostMapping("/addBook") 
    public String saveBook(@RequestBody Book book){ 
        repo.save(book); 
        
        return "Added Successfully"; 
    } 
    
    @GetMapping("/findAllDepts") 
    public List<Department> geDepartmentss() { 
        
        return departmentRepository.findAll(); 
    } 
  
    @GetMapping("/findAllBooks") 
    public List<Book> getBooks() { 
        
        return repo.findAll(); 
    } 
    
    @GetMapping("/find/{id}") 
    public Book getBookById(@PathVariable int id) { 
        
    	LOG.info("find book by ID " + id);
        return service.findById(id); 
    } 
  
    @DeleteMapping("/delete/{id}") 
    public String deleteBook(@PathVariable int id){ 
        repo.deleteById(id); 
        
        return "Deleted Successfully"; 
    } 
    
    
}
