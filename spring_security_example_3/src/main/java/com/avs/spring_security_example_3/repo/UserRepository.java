package com.avs.spring_security_example_3.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avs.spring_security_example_3.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{

    Users findByUsername(String username);

}