package com.example.repository;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryWithJPA extends JpaRepository<User,String>{
}
