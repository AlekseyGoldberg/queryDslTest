package com.example.querydsltest.builder;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Visitor;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.Objects;
import java.util.function.Function;

public class WhereClauseBuilder implements Predicate, Cloneable {

    private BooleanBuilder delegate;

    public WhereClauseBuilder() {
        this.delegate = new BooleanBuilder();
    }

    public WhereClauseBuilder(Predicate predicate) {
        this.delegate = new BooleanBuilder(predicate);
    }

    public WhereClauseBuilder and(Predicate right) {
        return new WhereClauseBuilder(delegate.and(right));
    }

    public <V> WhereClauseBuilder optionalAnd(V pValue, LazyBooleanExpression pBooleanExpression) {
        return applyIfNotNull(pValue, this::and, pBooleanExpression);
    }

    public <V> WhereClauseBuilder optionalAndEmpty(V pValue, LazyBooleanExpression pBooleanExpression, LazyBooleanExpression ifEmpty) {
        if (Objects.nonNull(pValue) && pValue.toString().isEmpty()) {
            return applyIfNotNull(pValue, this::and, ifEmpty);
        }
        return applyIfNotNull(pValue, this::and, pBooleanExpression);
    }


    public WhereClauseBuilder optionalAndBoolean(Boolean bValue, LazyBooleanExpression pBooleanExpression) {
        return null;
    }

    private <V> WhereClauseBuilder applyIfNotNull(V pValue, Function<Predicate, WhereClauseBuilder> pFunction, LazyBooleanExpression pBooleanExpression) {
        if (pValue != null) {
            return new WhereClauseBuilder(pFunction.apply(pBooleanExpression.get()));
        }

        return this;
    }

    @Override
    public <R, C> R accept(Visitor<R, C> visitor, C c) {
        return delegate.accept(visitor, c);
    }

    @Override
    public Class<? extends Boolean> getType() {
        return delegate.getType();
    }

    @Override
    public Predicate not() {
        return delegate.not();
    }

    @FunctionalInterface
    public interface LazyBooleanExpression {
        BooleanExpression get();
    }
}