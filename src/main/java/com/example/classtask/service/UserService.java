package com.example.classtask.service;

import com.example.classtask.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    String createUser(UserModel user);




}
