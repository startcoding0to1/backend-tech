package com.startcoding0to1.springboot_jwt_auth.repository;

import com.startcoding0to1.springboot_jwt_auth.entity.UserRegisterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;


public interface UserRegisterEntityRepository
        extends MongoRepository<UserRegisterEntity, Long> {

    Optional<UserRegisterEntity> findByUsername(String username);
}

