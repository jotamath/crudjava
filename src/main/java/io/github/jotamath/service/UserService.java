package io.github.jotamath.service;

import io.github.jotamath.entity.UserEntity;
import io.github.jotamath.exception.UserNotFoundException;
import io.vertx.ext.auth.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserService {
    public UserEntity createUser(UserEntity userEntity) {
        UserEntity.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> findAll(Integer page, Integer pageSize) {
        return UserEntity.findAll()
                .page(page, pageSize)
                .list();
    }

    public UserEntity findById(UUID userId) {
        return (UserEntity) UserEntity.findByIdOptional(userId)
                .orElseThrow(UserNotFoundException::new);
    }
}
