package com.revature.dummyapp.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.dummyapp.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
