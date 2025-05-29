package com.elira.taskManager.repository;

import com.elira.taskManager.entities.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    boolean existsByUuid(String sku);
}
