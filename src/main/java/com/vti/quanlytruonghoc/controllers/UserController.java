package com.vti.quanlytruonghoc.controllers;

import com.vti.quanlytruonghoc.dto.response.UserResponse;
import com.vti.quanlytruonghoc.models.Department;
import com.vti.quanlytruonghoc.models.User;
import com.vti.quanlytruonghoc.models.UserProfile;
import com.vti.quanlytruonghoc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping("/update")
    public User update(@RequestBody User user){
        return userService.update(user);
    }


    @PostMapping("/delete")
    public void delete(@RequestParam Long id){
        userService.delete(id);
    }
}
