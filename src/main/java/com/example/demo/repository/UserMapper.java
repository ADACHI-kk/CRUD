package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return ユーザー情報
     */
    User search(UserSearchRequest user);
    
    
    //insert
    public void insertOne(User u);
    
    //update
    public void updateName(User u);
    
    public void updateAddress(User u);
    
    public void updatePhone(User u);
    
    //delete
    public void deleteOne(User u);
}
