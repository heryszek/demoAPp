package com.qmapp.demo.service;

import com.qmapp.demo.model.Task;
import com.qmapp.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void saveTask(Task task) {
        logger.info("Saving task: " + task.toString());
        taskRepository.save(task);
        logger.info("Task saved successfully");
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
