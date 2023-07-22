package br.com.java.task.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.java.task.model.Task;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    Task findByTitle(String title);

    List<Task> findByIsDone(Boolean isDone);
}
