package com.spring.pratice.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pratice.models.User;

@Repository
public interface UserDetailsRepo extends JpaRepository<User,Long> {

}
