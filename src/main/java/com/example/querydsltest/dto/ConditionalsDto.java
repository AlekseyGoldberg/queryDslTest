package com.example.querydsltest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConditionalsDto {
    private List<ConditionalDto> conditionals;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ConditionalDto {
        private String column;
        private String operation;
        private String value;
    }
}
