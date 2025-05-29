package com.elira.taskManager.service;

import com.elira.taskManager.entities.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    List<TaskEntity> findAll();
    Optional<TaskEntity> findTaskById(Long id);
    TaskEntity createTask(TaskEntity task);
    Optional<TaskEntity> updatedTaskById(Long id, TaskEntity newTask);
    Optional<TaskEntity> updatedTaskDoneById(Long id, boolean isDone);
    Optional<TaskEntity> deleteTaskById(Long id);
    boolean existsByUuid(String sku);
}
