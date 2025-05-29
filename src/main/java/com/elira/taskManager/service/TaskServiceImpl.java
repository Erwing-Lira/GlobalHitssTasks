package com.elira.taskManager.service;

import com.elira.taskManager.entities.TaskEntity;
import com.elira.taskManager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskEntity> findAll() {
        return (List<TaskEntity>) taskRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TaskEntity> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    @Transactional
    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public Optional<TaskEntity> updatedTaskById(Long id, TaskEntity newTask) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            TaskEntity task = optionalTask.get();
            if (newTask.getTitle() != null) {
                task.setTitle(newTask.getTitle());
            }
            if (newTask.getDescription() != null) {
                task.setDescription(newTask.getDescription());
            }
            if (newTask.getDone() != null) {
                task.setDone(newTask.getDone());
            }
            if (newTask.getUuid() != null) {
                task.setUuid(newTask.getUuid());
            }
            return Optional.of(taskRepository.save(task));

        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<TaskEntity> updatedTaskDoneById(Long id, boolean isDone) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            TaskEntity task = optionalTask.get();
            task.setDone(isDone);
            return Optional.of(taskRepository.save(task));
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<TaskEntity> deleteTaskById(Long id) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        optionalTask.ifPresent(taskRepository::delete);
        return optionalTask;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUuid(String sku) {
        return taskRepository.existsByUuid(sku);
    }
}
