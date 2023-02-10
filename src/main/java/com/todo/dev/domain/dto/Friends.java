package com.todo.dev.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Friends {
    private Integer my_id;
    private Integer target_id;
    private LocalDateTime create_date;
}
