package com.msnirmal1487.sample.sched;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository
 extends JpaRepository<Department, Long> {
}