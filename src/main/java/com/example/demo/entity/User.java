package com.example.demo.entity;

import lombok.Data;

@Data
public class User {

    //ID
    private Long id;
    
    //名前
    private String name;
    
    //住所
    private String address;
    
    //電話番号
    private String phone;
}
