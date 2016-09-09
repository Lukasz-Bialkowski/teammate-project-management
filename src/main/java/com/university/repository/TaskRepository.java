package com.university.repository;

import com.university.crud.CrudfsRepository;
import com.university.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
