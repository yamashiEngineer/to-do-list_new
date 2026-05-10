package com.todo.todo_list.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter, Setter, toString, equals, hashCode を自動生成
@NoArgsConstructor // すべてのフィールドを引数に持つコンストラクタを自動生成
@AllArgsConstructor
public class Todo {
    private Long id;
    private String task;
    private boolean completed;
}
