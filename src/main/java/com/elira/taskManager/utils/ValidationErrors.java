package com.elira.taskManager.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrors {
    public static ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> mapError = new HashMap<>();
        result.getFieldErrors().forEach( error ->
                mapError.put(
                        error.getField(),
                        "Field " + error.getField() + " " + error.getDefaultMessage()
                )
        );
        return ResponseEntity.badRequest().body(mapError);
    }
}
