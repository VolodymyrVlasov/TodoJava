package com.example.todo_list.service.impl;

import com.example.todo_list.model.Order;
import com.example.todo_list.repository.TaskRepository;
import com.example.todo_list.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MySqlOrderService implements OrderService {

    private TaskRepository taskRepository;

    @Autowired
    public MySqlOrderService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Order> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        if ((Long) order.getId() == 0) {
            order.setCreatedDate(LocalDateTime.now());
            return taskRepository.save(order);
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        if (taskRepository.existsById(order.getId())) {
            return taskRepository.save(order);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }
    }

    @Override
    public List<Order> findAnyMatch(String key) {
        return taskRepository.findAll().stream()
                .filter(order -> {
                    if (String.valueOf(order.getId()).equals(key)) return true;
                    return false;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Order getById(long id) {
        return taskRepository.findById(id).orElse(null);
    }
}
