package com.rks.protobuff_excersice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rks.protobuff_excersice.model.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {

}
