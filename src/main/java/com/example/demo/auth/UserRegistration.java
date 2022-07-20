package com.example.demo.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegistration implements Serializable {
//    private Long id;
    private  String password;
    private  String userName;
//    private  boolean isAccountNonExpired;
//    private  boolean isAccountNonLocked;
//    private  boolean isCredentialsNonExpired;
//    private  boolean isEnabled;
}
