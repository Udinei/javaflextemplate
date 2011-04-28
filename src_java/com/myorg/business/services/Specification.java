package com.myorg.business.services;

public interface Specification<T> {   
    boolean isSatisfiedBy(T t);
   
} 