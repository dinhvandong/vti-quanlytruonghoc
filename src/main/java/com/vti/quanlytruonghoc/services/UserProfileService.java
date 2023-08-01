package com.vti.quanlytruonghoc.services;

import com.vti.quanlytruonghoc.models.User;
import com.vti.quanlytruonghoc.models.UserProfile;
import com.vti.quanlytruonghoc.repositories.UserProfileRepository;
import com.vti.quanlytruonghoc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserProfileService {

    @Autowired
    UserProfileRepository userProfileRepository;
    public UserProfile insert(UserProfile user){
        return userProfileRepository.save(user);
    }
    public UserProfile update(UserProfile user){
        Optional<UserProfile> optionalUser = userProfileRepository.findById(user.getId());
        if(optionalUser.isPresent()){
            return userProfileRepository.save(user);
        }
        return null;
    }
    public void delete(Long id){
        userProfileRepository.deleteById(id);
    }
    public UserProfile getInfo(Long id)
    {
        return userProfileRepository.findById(id).get();
    }
    public List<UserProfile> findAll()
    {
        return userProfileRepository.findAll();
    }
}
