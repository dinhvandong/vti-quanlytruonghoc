package com.vti.quanlytruonghoc.services;


import com.vti.quanlytruonghoc.dto.response.UserResponse;
import com.vti.quanlytruonghoc.models.User;
import com.vti.quanlytruonghoc.models.UserProfile;
import com.vti.quanlytruonghoc.repositories.UserProfileRepository;
import com.vti.quanlytruonghoc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Configurable
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;
    public User insert(User user){
        return userRepository.save(user);
    }

    public User insertProfile(Long idUser, UserProfile profile){

        Optional<User> optionalUser = userRepository.findById(idUser);
        if(optionalUser.isPresent()){

            User userFound = optionalUser.get();
            userFound.setUserProfile(profile);
            return userRepository.save(userFound);
        }
        return null;
    }
    public User update(User user){
        Optional<User> optionalUser = userRepository.findById(user.getId());
        if(optionalUser.isPresent()){
           return userRepository.save(user);
        }
        return null;
    }
    public void delete(Long id){
        userRepository.deleteById(id);
    }
    public User getInfo(Long id)
    {
        return userRepository.findById(id).get();
    }
    public List<UserResponse> findAll()
    {
        List<User> userList = userRepository.findAll();
        List<UserResponse> returnList = new ArrayList<>();
        for(User user: userList){
           UserProfile profile = user.getUserProfile();
            System.out.println("profile:"+ profile.toString());
            UserResponse userResponse = new UserResponse();
            userResponse.setUserProfile(profile);
            userResponse.setUser(user);
            returnList.add(userResponse);
        }
        return returnList;
    }
}
