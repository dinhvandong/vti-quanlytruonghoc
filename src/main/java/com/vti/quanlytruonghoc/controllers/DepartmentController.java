package com.vti.quanlytruonghoc.controllers;


import com.vti.quanlytruonghoc.models.Department;
import com.vti.quanlytruonghoc.repositories.DepartmentRepository;
import com.vti.quanlytruonghoc.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/findAll")
    public List<Department> findAll()
    {
       return  departmentService.findAll();
    }
    @PostMapping("/insert")
    public Department insert(@RequestBody Department department)
    {
        return  departmentService.insert(department);
    }


    @PostMapping("/update")
    public Department update(@RequestBody Department department){
        return departmentService.update(department);
    }


    @PostMapping("/delete")
    public void delete(@RequestParam int id){
         departmentService.delete(id);
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
