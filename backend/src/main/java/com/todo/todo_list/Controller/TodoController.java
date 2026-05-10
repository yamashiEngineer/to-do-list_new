package com.todo.todo_list.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import com.todo.todo_list.Entity.*;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:5173") // Reactからのアクセスを許可
public class TodoController {
    private List<Todo> todos = new ArrayList<>(Arrays.asList(
        new Todo(1L, "洗車する", false),
        new Todo(2L, "自動車税を払う", false)
    ));
    
    @GetMapping
    public List<Todo> getAll(){
        return todos;
    }

    @PostMapping
    public Todo add(@RequestBody Todo todo){
        todo.setId(System.currentTimeMillis()); //IDに一意にするため
        todos.add(todo);
        return todo;
    }
}
