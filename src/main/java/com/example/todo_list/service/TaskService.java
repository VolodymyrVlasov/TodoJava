package com.example.todo_list.service;

import com.example.todo_list.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task addTask(Task task);

    Task updateTask(Task task) throws Exception;

    void removeTask(long id);

    List<Task> getTaskListByAuthor(String author);

    List<Task> findAnyMatch(String key);
}
