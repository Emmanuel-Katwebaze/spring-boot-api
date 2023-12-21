package com.emmakatwebaze.SpringBootpractice.repository;

import com.emmakatwebaze.SpringBootpractice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);

    // can also use @Query() annotation for complex queries
}
