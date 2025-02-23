package me.dio.rest.service.impl;

import me.dio.rest.domain.model.User;
import me.dio.rest.domain.repository.UserRepository;
import me.dio.rest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        boolean idExists = user.getId() != null && userRepository.existsById(user.getId());

        if (idExists) {
            throw new IllegalArgumentException("User with the given ID (%d) already exists.".formatted(user.getId()));
        }

        if (userRepository.existsByAccountNumberAndAccountAgency(user.getAccount().getNumber(), user.getAccount().getAgency())) {
            throw new IllegalArgumentException("User with the given account (%s - %s) already exists.".formatted(user.getAccount().getAgency(), user.getAccount().getNumber()));
        }

        return userRepository.save(user);
    }
}
