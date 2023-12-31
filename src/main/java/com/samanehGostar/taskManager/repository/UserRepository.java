package com.samanehGostar.taskManager.repository;

import com.samanehGostar.taskManager.domian.entities.Task;
import com.samanehGostar.taskManager.domian.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);


}
