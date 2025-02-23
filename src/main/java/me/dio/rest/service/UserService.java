package me.dio.rest.service;

import me.dio.rest.domain.model.User;

public interface UserService {
    User findById(Long id);

    User create(User user);
}
