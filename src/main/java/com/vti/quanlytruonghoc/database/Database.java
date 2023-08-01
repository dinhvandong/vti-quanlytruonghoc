package com.vti.quanlytruonghoc.database;

import com.vti.quanlytruonghoc.models.Department;
import com.vti.quanlytruonghoc.repositories.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    // Se duoc goi khi bat dau chay chuong trinh
    // Co nghia la moi lan run len thi phai chay qua @Configuration
    @Bean
    CommandLineRunner initDatabase(DepartmentRepository departmentRepo){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Department department1 = new Department();
                department1.setId(1);
                department1.setName("IT");
                department1.setDesc("CNTT");
                Department department2 = new Department();
                department2.setId(2);
                department2.setName("MKT");
                department2.setDesc("Marketing");
                if(departmentRepo.findAll().size()==0){
                    departmentRepo.save(department1); // INSERT TABLE DEPARTMENT
                    departmentRepo.save(department2); //INSERT TABLE DEPARTMENT
                }
            }
        };
    }
}
