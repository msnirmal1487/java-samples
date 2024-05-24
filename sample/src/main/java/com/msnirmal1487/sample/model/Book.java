package com.msnirmal1487.sample.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document( collection = "Book")
public class Book implements Serializable {

	
	private static final long serialVersionUID = -3011259593887518592L;
	// Attributes 
    @Id 
    private int id; 
    private String bookName; 
    private String authorName; 
}
