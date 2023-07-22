package br.com.java.task.service;

import java.util.List;

import br.com.java.task.model.Task;

public interface TaskService {

    List<Task> findAll();

    Task findOneByTitle(String title);

    Task create(Task task);

    Task update(String id, Task task);

    void remove(String id);

}
