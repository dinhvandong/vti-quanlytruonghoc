package com.vti.quanlytruonghoc.repositories;

import com.vti.quanlytruonghoc.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository
        extends JpaRepository<Department, Integer>  //<Model, ID_Type>
{
    // Cung cap cac phuong thuc de lam viec voi Table
    // Insert
    // Update
    // Delete
    // FindAll
    // FindbyID
}
