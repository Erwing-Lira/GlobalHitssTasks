package com.elira.taskManager.validation;

import com.elira.taskManager.service.ITaskService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class IsExistsDBValidation implements ConstraintValidator<IsExistsDB, String> {
    @Autowired
    private ITaskService taskService;

    @Override
    public boolean isValid(
            String value,
            ConstraintValidatorContext constraintValidatorContext
    ) {
        if (taskService == null) return true;
        return !taskService.existsByUuid(value);
    }
}
