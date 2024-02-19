package com.example.querydsltest.controler;

import com.example.querydsltest.dto.ConditionalsDto;
import com.example.querydsltest.entity.User;
import com.example.querydsltest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ConditionalController {
    private final UserService userService;

    @PostMapping
    public User testController(@RequestBody ConditionalsDto conditionalsDto) {
        return userService.createConditional(conditionalsDto);
    }

}
