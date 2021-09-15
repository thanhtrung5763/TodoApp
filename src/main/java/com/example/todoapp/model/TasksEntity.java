package com.example.todoapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(TasksEntityPK.class)
@Table(name= "tasks", schema = "public", catalog = "TodoApp")
public class TasksEntity {

    private String email;
    private String taskName;
    private int priority;
    private int taskId;

    public TasksEntity() {
    }

    public TasksEntity(String email, String taskName, int priority) {
        this.email = email;
        this.taskName = taskName;
        this.priority = priority;
    }

    public TasksEntity(String email,String taskName, int priority, int taskId) {
        this.email = email;
        this.taskName = taskName;
        this.priority = priority;
        this.taskId = taskId;
    }

    @Id
    @Column(name = "email", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "task_name", nullable = false, length = 50)
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Basic
    @Column(name = "priority", nullable = false)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "task_id", nullable = false)
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TasksEntity that = (TasksEntity) o;

        if (priority != that.priority) return false;
        if (taskId != that.taskId) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (taskName != null ? !taskName.equals(that.taskName) : that.taskName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + priority;
        result = 31 * result + taskId;
        return result;
    }
}
