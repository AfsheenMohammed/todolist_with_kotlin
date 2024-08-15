package com.example.todolist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var  todoAdapter: TodoAdapter
    private lateinit var rvTodoItems: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        rvTodoItems = findViewById(R.id.rvTodoItems)


        val etTodoTitle:EditText = findViewById(R.id.TodoTitle)
        val btnAddTodo:Button=findViewById(R.id.btnAddTodo)
        val btnDeleteDoneTodos:Button = findViewById(R.id.btnDeleteDoneTodos)


        todoAdapter= TodoAdapter(mutableListOf())
        rvTodoItems.adapter= todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


         btnAddTodo.setOnClickListener{
             val todoTitle=etTodoTitle.text.toString()
             if(todoTitle.isNotEmpty()){
                 val todo = Todo(todoTitle)
                 todoAdapter.addTodo(todo)
                 etTodoTitle.text.clear()
             }
         }
        btnDeleteDoneTodos.setOnClickListener{
            todoAdapter.deleteDoneTodos()
        }
        }

    }

