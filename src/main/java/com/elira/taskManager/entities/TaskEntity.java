package com.elira.taskManager.entities;

import com.elira.taskManager.validation.IsExistsDB;
import com.elira.taskManager.validation.IsRequired;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsRequired(message = "{NotBlank.task.title}")
    @Size(min = 5, max = 50)
    private String title;

    @IsRequired(message = "{NotBlank.task.description}")
    private String description;

    @NotNull(message = "{NotBlank.task.done}")
    private Boolean done;

    @IsExistsDB(message = "{IsExistsDB.task.uuid}")
    private String uuid;
}
