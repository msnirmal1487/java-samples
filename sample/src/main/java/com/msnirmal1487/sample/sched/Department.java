package com.msnirmal1487.sample.sched;
import jakarta.persistence.Column;
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
public class Department {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "department_id")
 private Long departmentId;
 @Column(name = "department_name")
 private String departmentName;
 @Column(name = "department_address")
 private String departmentAddress;
 @Column(name = "department_code")
 private String departmentCode;
}