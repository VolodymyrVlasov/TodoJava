package com.example.todo_list.repository;

import com.example.todo_list.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Order, Long> {

}
