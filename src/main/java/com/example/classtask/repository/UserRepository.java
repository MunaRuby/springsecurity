package com.example.classtask.repository;

import com.example.classtask.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);

    Boolean existsByEmail(String email);

    UserModel findUserModelByUsername(String username);

}
