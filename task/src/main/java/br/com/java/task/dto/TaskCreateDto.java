package br.com.java.task.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateDto {
    @NotEmpty
    @Size(min = 2, message = "title name should have at least 2 characters")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "description name should have at least 10 characters")
    private String description;

    private Boolean isDone = true;
}
