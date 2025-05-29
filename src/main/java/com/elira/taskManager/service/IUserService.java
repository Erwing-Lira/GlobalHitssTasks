package com.elira.taskManager.service;

import com.elira.taskManager.entities.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User save(User user);
}
