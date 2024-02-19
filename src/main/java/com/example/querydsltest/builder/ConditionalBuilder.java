package com.example.querydsltest.builder;

import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public class ConditionalBuilder {
    public static Map<String, Map<String, Function<String, BooleanExpression>>> mapOfConditional =
            Map.of(
                    "id", Map.of(
                            "eq", (value) -> QUser.user.id.eq(UUID.fromString(value)),
                            "notEq", (value) -> QUser.user.id.notIn(UUID.fromString(value))
                    ),
                    "username", Map.of(
                            "eq", (value) -> QUser.user.username.eq(value),
                            "notEq", (value) -> QUser.user.username.notIn(value)
                    ),
                    "age", Map.of(
                            "eq", (value) -> QUser.user.age.eq(Integer.parseInt(value)),
                            "notEq", (value) -> QUser.user.age.notIn(Integer.parseInt(value))
                    )
            );
}
