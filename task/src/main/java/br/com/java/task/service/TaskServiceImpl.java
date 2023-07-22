package br.com.java.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.java.task.model.Task;
import br.com.java.task.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Override
    public Task findOneByTitle(String title) {
        Task task = this.taskRepository.findByTitle(title);

        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return task;
    }

    @Override
    public Task create(Task task) {
        Task existTask = this.taskRepository.findByTitle(task.getTitle());

        if (existTask != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Already exist this task!");
        }

        return this.taskRepository.save(task);
    }

    @Override
    public Task update(String id, Task task) {
        Optional<Task> existTask = this.taskRepository.findById(id);

        if (existTask.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        task.setId(id);
        task.setTitle(existTask.get().getTitle());

        return this.taskRepository.save(task);
    }

    @Override
    public void remove(String id) {
        Optional<Task> existTask = this.taskRepository.findById(id);

        if (existTask.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        this.taskRepository.deleteById(id);
    }

}
