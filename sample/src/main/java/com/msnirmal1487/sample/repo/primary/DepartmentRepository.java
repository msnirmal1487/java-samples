package com.msnirmal1487.sample.repo.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msnirmal1487.sample.model.primary.Department;

@Repository
public interface DepartmentRepository
 extends JpaRepository<Department, Long> {
}