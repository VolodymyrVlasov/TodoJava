package com.example.todo_list.service.impl;

import com.example.todo_list.model.Task;
import com.example.todo_list.repository.TaskRepository;
import com.example.todo_list.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class MySqlTaskService implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public MySqlTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task addTask(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) throws Exception {
        if (!taskRepository.existsById(task.getId())) {
            throw new Exception("Task " + task.getId() + " not found");
        }
        return taskRepository.save(task);
    }

    @Override
    public void removeTask(long id) {
        taskRepository.deleteById(id);
        //todo: in what type return result?
    }

    @Override
    public List<Task> getTaskListByAuthor(String author) {
        return taskRepository.findAll().stream()
                .filter(task -> task.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> findAnyMatch(String key) {
        return taskRepository.findAll().stream()
                .filter(task -> {
                    if (String.valueOf(task.getId()).equals(key)) return true;
                    return false;
                })
                .collect(Collectors.toList());
    }
}
