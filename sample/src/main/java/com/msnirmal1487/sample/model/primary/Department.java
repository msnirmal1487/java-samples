package com.msnirmal1487.sample.model.primary;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//Importing required classes
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

//Class 
public class Department {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long departmentId;
 private String departmentName;
 private String departmentAddress;
 private String departmentCode;
}