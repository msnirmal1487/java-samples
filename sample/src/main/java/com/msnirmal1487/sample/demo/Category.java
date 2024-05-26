package com.msnirmal1487.sample.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotations 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)

	 @Column(name = "category_id")
	 private Long categoryId;
	 @Column(name = "category_name")
	 private String categoryName;
	 @Column(name = "category_address")
	 private String categoryAddress;
	 @Column(name = "category_code")
	 private String categoryCode;
}
