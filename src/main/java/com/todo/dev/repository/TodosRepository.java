package com.todo.dev.repository;

import com.todo.dev.domain.dto.Todos;
import com.todo.dev.domain.dto.TodosPost;
import com.todo.dev.domain.request.TodosPostRequest;
import com.todo.dev.security.TokenRequired;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodosRepository {

    Integer insert(Todos todos);
}
