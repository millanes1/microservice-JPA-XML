package com.example.demo.rest;

import com.example.demo.rest.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by millanes on 17-03-17.
 */

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(name = "TaskRepository.findByWorpackageId")
   public List<Task> findByWorkpackageId(@Param("workpackageId") Integer workpackageId);
}
