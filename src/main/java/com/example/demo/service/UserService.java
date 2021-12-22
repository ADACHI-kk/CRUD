package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;

@Service
public class UserService {
	
    @Autowired
    private UserMapper userMapper;
    
    //read
    public User search(UserSearchRequest userSearchRequest) {
        return userMapper.search(userSearchRequest);
    }
    
    //insert
    public void insertOne(User u) {
        userMapper.insertOne(u);
    }
    
    //update
    public void updateName(User u) {
    	userMapper.updateName(u);
    }
    
    public void updateAddress(User u) {
    	userMapper.updateAddress(u);
    }
    
    public void updatePhone(User u) {
    	userMapper.updatePhone(u);
    }
    
    //delete
    public void deleteOne(User u) {
    	userMapper.deleteOne(u);
    }
}
