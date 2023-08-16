package com.vti.quanlytruonghoc.controllers;


import com.vti.quanlytruonghoc.models.Department;
import com.vti.quanlytruonghoc.models.User;
import com.vti.quanlytruonghoc.repositories.DepartmentRepository;
import com.vti.quanlytruonghoc.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/insertUser")
    public Department insertUser(@RequestParam Integer departmentID, @RequestBody User user)
    {
        return  departmentService.insertUser(departmentID, user);
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



    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer departmentId) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(departmentOptional.get());
    }

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentRepository.save(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartment);
    }

    @PutMapping("/{departmentId}")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable Integer departmentId,
            @RequestBody Department updatedDepartment
    ) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        updatedDepartment.setId(departmentId);
        Department savedDepartment = departmentRepository.save(updatedDepartment);
        return ResponseEntity.ok(savedDepartment);
    }

    @DeleteMapping("/{departmentId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Integer departmentId) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        departmentRepository.deleteById(departmentId);
        return ResponseEntity.noContent().build();
    }
}
