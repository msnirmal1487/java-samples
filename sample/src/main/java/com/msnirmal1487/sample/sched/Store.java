package com.msnirmal1487.sample.sched;

import com.msnirmal1487.sample.sched.Department.DepartmentBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "StoreId")
	private Long storeId;
	
	@Column(name = "StoreNumber")
	private int storeNumber;
	
	@Column(name = "IsActive")
	private boolean isActive;
	
	@Column(name = "State")
	private String state;

}
