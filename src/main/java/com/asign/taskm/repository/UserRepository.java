package com.asign.taskm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asign.taskm.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
