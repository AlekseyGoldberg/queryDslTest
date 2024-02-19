package com.example.querydsltest.repository;

import com.example.querydsltest.entity.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends QuerydslPredicateExecutor<User>, CrudRepository<User, UUID> {
}
