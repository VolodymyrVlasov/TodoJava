package com.example.todo_list.service;

import com.example.todo_list.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAll();

    Order create(Order order);

    Order update(Order order);

    void deleteById(long id);

    List<Order> findAnyMatch(String key);

    Order getById(long id);
}
