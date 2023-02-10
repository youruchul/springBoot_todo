package com.todo.dev.security;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //언제 살펴볼거나
@Target({ElementType.TYPE, ElementType.METHOD}) // 어디냐 쓸거냐
public @interface TokenRequired {
}
