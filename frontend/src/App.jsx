import React, { useState, useEffect } from 'react';

function App() {
  const [todos, setTodos] = useState([]);
  const [input, setInput] = useState('');

  // 1. データ取得 (Read)
  useEffect(() => {
    fetch('http://localhost:8080/api/todos')
      .then(res => res.json())
      .then(data => setTodos(data));
  }, []);

  // 2. データ追加 (Create)
  const addTodo = () => {
    fetch('http://localhost:8080/api/todos', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ task: input, completed: false })
    })
    .then(res => res.json())
    .then(newTodo => setTodos([...todos, newTodo]));
    setInput('');
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>ToDo List</h1>
      <input 
        value={input} 
        onChange={(e) => setInput(e.target.value)} 
        placeholder="新しいタスク"
      />
      <button onClick={addTodo}>追加</button>
      
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>{todo.task}</li>
        ))}
      </ul>
    </div>
  );
}

export default App;