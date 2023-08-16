package com.vti.quanlytruonghoc.controllers;

import com.vti.quanlytruonghoc.dto.response.UserResponse;
import com.vti.quanlytruonghoc.models.Department;
import com.vti.quanlytruonghoc.models.User;
import com.vti.quanlytruonghoc.models.UserProfile;
import com.vti.quanlytruonghoc.repositories.UserRepository;
import com.vti.quanlytruonghoc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/findAll")
    public List<UserResponse> findAll()
    {
        return  userService.findAll();
    }
    @PostMapping("/insert")
    public User insert(@RequestBody User user)
    {
        return  userService.insert(user);
    }
    @PostMapping("/insertProfile")
    public User insert(@RequestParam Long userID,
                       @RequestBody UserProfile profile)
    {
        return  userService.insertProfile(userID, profile);
    }
    @PostMapping("/insertDepartment")
    public User insert(@RequestParam Long userID,
                       @RequestParam Integer departmentID)
    {
        return  userService.insertDepartment(userID, departmentID);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }


    @PostMapping("/delete")
    public void delete(@RequestParam Long id){
        userService.delete(id);
    }


    @Autowired
    private UserRepository employeeRepository;

    @GetMapping
    public List<User> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<User> getEmployeeById(@PathVariable Long employeeId) {
        Optional<User> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeOptional.get());
    }

    @PostMapping
    public ResponseEntity<User> createEmployee(@RequestBody User employee) {
        User createdEmployee = employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<User> updateEmployee(
            @PathVariable Long employeeId,
            @RequestBody User updatedEmployee
    ) {
        Optional<User> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        updatedEmployee.setId(employeeId);
        User savedEmployee = employeeRepository.save(updatedEmployee);
        return ResponseEntity.ok(savedEmployee);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
        Optional<User> employeeOptional = employeeRepository.findById(employeeId);
        if (employeeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(employeeId);
        return ResponseEntity.noContent().build();
    }

}
