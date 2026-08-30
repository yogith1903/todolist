package com.yogith.todolist;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText taskInput;
    Button addButton;
    RecyclerView taskRecyclerView;

    ArrayList<Task> taskList;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        taskInput = findViewById(R.id.taskInput);
        addButton = findViewById(R.id.addButton);
        taskRecyclerView = findViewById(R.id.taskRecyclerView);

        taskList = new ArrayList<>();

        taskAdapter = new TaskAdapter(taskList);

        taskRecyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        taskRecyclerView.setAdapter(taskAdapter);

        addButton.setOnClickListener(v -> {

            String taskText = taskInput.getText()
                    .toString()
                    .trim();

            if (taskText.isEmpty()) {

                Toast.makeText(
                        this,
                        "Please enter a task",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            Task newTask = new Task(taskText);

            taskList.add(newTask);

            taskAdapter.notifyItemInserted(
                    taskList.size() - 1
            );

            taskInput.setText("");
        });
    }
}