package com.yogith.todolist;

public class Task {

    private String taskName;
    private boolean completed;

    public Task(String taskName) {
        this.taskName = taskName;
        this.completed = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
