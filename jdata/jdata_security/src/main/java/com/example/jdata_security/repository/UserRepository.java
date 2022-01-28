package com.example.jdata_security.repository;

import com.example.jdata_security.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
