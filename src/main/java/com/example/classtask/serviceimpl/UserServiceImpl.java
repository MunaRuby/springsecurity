package com.example.classtask.serviceimpl;

import com.example.classtask.model.UserModel;
import com.example.classtask.repository.UserRepository;
import com.example.classtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, final PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String createUser(UserModel user) {

        String feedback = "";

        if(userRepository.existsByEmail(user.getEmail())){

            feedback = user.getUsername() + " already exists";

        }else{
            user.setUsername(user.getEmail());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            feedback = user.getUsername() + " created";
        }

        return feedback;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByEmail(username);
        if(userDetails == null){
            throw new UsernameNotFoundException("Username not found");
        }else{
            return userDetails;
        }
    }
}
