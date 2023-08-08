package com.vti.quanlytruonghoc.services;


import com.vti.quanlytruonghoc.models.Department;
import com.vti.quanlytruonghoc.models.User;
import com.vti.quanlytruonghoc.repositories.DepartmentRepository;
import com.vti.quanlytruonghoc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configurable
public class DepartmentService {
    @Autowired // Autowrite dung de khoi tao doi tuong ma ko can dung tu khoa new
    DepartmentRepository departmentRepository;

    @Autowired
    UserRepository userRepository;

    public List<Department> findAll()
    {
        return departmentRepository.findAll();
    }

    public Department insert(Department department){

        return departmentRepository.save(department);
    }


    public Department insertUser(Integer departmentID, User user){
        Department department = departmentRepository.findById(departmentID).get();
       // user.setDepartment(department);
        User user1 = userRepository.save(user);
      //  department.getUsers().add(user1);

        return departmentRepository.save(department);
    }

    public Department update(Department department){

        Optional<Department> optionalDepartment
                = departmentRepository.findById(department.getId());
        // Goi den repository department va tim trong Table Department xem co data ID =  input

        if(optionalDepartment.isPresent()){
            return departmentRepository.save(department);
        }
        return null;
    }

    public void delete(int id){
        Optional<Department> optionalDepartment
                = departmentRepository.findById(id);
        if(optionalDepartment.isPresent()){
            departmentRepository.deleteById(id);
        }
    }
}
