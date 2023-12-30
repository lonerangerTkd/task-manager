package com.samanehGostar.taskManager.repository;

import com.samanehGostar.taskManager.domian.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository  extends JpaRepository<Task,Long> {
}
