package br.com.java.task.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Document("tasks")
public class Task {
    @Id
    public String id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private Boolean isDone;
}
