package com.revature.dummyapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.dummyapp.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
