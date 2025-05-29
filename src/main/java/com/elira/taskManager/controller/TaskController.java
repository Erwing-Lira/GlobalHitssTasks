package com.elira.taskManager.controller;

import com.elira.taskManager.entities.TaskEntity;
import com.elira.taskManager.service.ITaskService;
import com.elira.taskManager.utils.ValidationErrors;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    /*@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new TaskValidation());
    }*/

    @GetMapping
    public ResponseEntity<List<TaskEntity>> fetchAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findTaskById(
            @PathVariable Long id
    ) {
        Optional<TaskEntity> taskOptional = taskService.findTaskById(id);
        if (taskOptional.isPresent()) {
            return ResponseEntity.ok(taskOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<?> createTask(
            @Valid @RequestBody TaskEntity task,
            BindingResult result
    ) {
        if (result.hasFieldErrors()) {
            return ValidationErrors.validation(result);
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(taskService.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTaskById(
            @Valid @RequestBody TaskEntity task,
            BindingResult result,
            @PathVariable Long id
    ) {
        if (result.hasFieldErrors()) {
            return ValidationErrors.validation(result);
        }
        Optional<TaskEntity> taskOptional = taskService.updatedTaskById(id, task);
        if (taskOptional.isPresent()) {
            return ResponseEntity.ok(taskOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/{isDone}")
    public ResponseEntity<?> updateTaskDoneById(
            @PathVariable Long id,
            @PathVariable Boolean isDone
    ) {
        Optional<TaskEntity> taskOptional = taskService.updatedTaskDoneById(id, isDone);
        if (taskOptional.isPresent()) {
            return ResponseEntity.ok(taskOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskById(
            @PathVariable Long id
    ) {
        Optional<TaskEntity> taskOptional = taskService.deleteTaskById(id);
        if (taskOptional.isPresent()) {
            return ResponseEntity.ok(taskOptional.get());
        }
        return ResponseEntity.notFound().build();
    }
}
