package br.com.java.task.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.java.task.dto.TaskCreateDto;
import br.com.java.task.dto.TaskUpdateDto;
import br.com.java.task.model.Task;
import br.com.java.task.service.TaskService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TaskService taskService;

    @GetMapping
    List<Task> findAll() {
        return this.taskService.findAll();
    }

    @GetMapping("/{title}")
    Task findOneByTitle(@PathVariable("title") String title) {
        return this.taskService.findOneByTitle(title);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    Task create(@Valid @RequestBody TaskCreateDto createTaskDto) {
        Task task = modelMapper.map(createTaskDto, Task.class);
        return this.taskService.create(task);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    Task update(@PathVariable("id") String id, @Valid @RequestBody TaskUpdateDto updateTaskDto) {
        Task task = modelMapper.map(updateTaskDto, Task.class);
        return this.taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void remove(@PathVariable("id") String id) {
        this.taskService.remove(id);
    }
}
