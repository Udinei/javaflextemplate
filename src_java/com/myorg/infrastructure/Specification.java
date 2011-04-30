package com.myorg.infrastructure;

public interface Specification<T> {   
    boolean isSatisfiedBy(T t);
   
} 