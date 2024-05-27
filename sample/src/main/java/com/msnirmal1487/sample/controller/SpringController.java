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

import com.msnirmal1487.sample.demo.Category;
import com.msnirmal1487.sample.demo.CategoryRepository;
import com.msnirmal1487.sample.model.Book;
import com.msnirmal1487.sample.repo.BookRepo;
import com.msnirmal1487.sample.sched.Department;
import com.msnirmal1487.sample.sched.DepartmentRepository;
import com.msnirmal1487.sample.sched.Store;
import com.msnirmal1487.sample.sched.StoreRepository;
import com.msnirmal1487.sample.service.BookService;
import com.msnirmal1487.sample.service.JdbcService;

@RestController
public class SpringController {

	private static final Logger LOG = LoggerFactory.getLogger(SpringController.class);
	
	@Autowired
    private BookRepo repo; 
	
	@Autowired
	private BookService service;
	
	@Autowired
	private JdbcService jdbcService;
	
	@Autowired
    private DepartmentRepository departmentRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
    private CategoryRepository categoryRepository;
  
    @PostMapping("/addBook") 
    public String saveBook(@RequestBody Book book){ 
        repo.save(book); 
        
        return "Added Successfully"; 
    } 
    
    @GetMapping("/findAllStores") 
    public List<Store> getStores() { 
        
        return storeRepository.findAll(); 
    } 
    
    @GetMapping("/findAllDepts") 
    public List<Department> getDepartments() { 
        
        return departmentRepository.findAll(); 
    } 
    
    @GetMapping("/getDeptIds") 
    public List<Long> getDepartmentIds() { 
        
        return jdbcService.getDepartmentIds(); 
    } 
    
    @GetMapping("/findAllCateg") 
    public List<Category> getCategories() { 
        
        return categoryRepository.findAll(); 
    } 
    
    @GetMapping("/getCategIds") 
    public List<Long> getCategIds() { 
        
        return jdbcService.getCategoryIds(); 
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
