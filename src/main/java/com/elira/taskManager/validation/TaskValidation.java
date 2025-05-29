package com.elira.taskManager.validation;

import com.elira.taskManager.entities.TaskEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TaskValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TaskEntity.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", null, "Title is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", null, "Description is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "done", null, "Done is required");

        TaskEntity taskEntity = (TaskEntity) target;
        if (taskEntity.getUuid() == null) {
            errors.reject("uuid", null, "UUID is required");
        }
    }
}
