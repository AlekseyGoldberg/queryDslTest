package com.example.querydsltest.service;

import com.example.querydsltest.builder.ConditionalBuilder;
import com.example.querydsltest.builder.WhereClauseBuilder;
import com.example.querydsltest.dto.ConditionalsDto;
import com.example.querydsltest.entity.User;
import com.example.querydsltest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User createConditional(ConditionalsDto dto) {
        WhereClauseBuilder builder = new WhereClauseBuilder();
        for (ConditionalsDto.ConditionalDto conditional : dto.getConditionals()) {
            builder.and(
                    ConditionalBuilder
                            .mapOfConditional.get(conditional.getColumn())
                            .get(conditional.getOperation())
                            .apply(conditional.getValue())
            );
        }
        return userRepository.findOne(builder).orElse(null);
    }
}
