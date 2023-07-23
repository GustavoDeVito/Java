package br.com.java.post.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {
    @NotEmpty
    @Size(min = 2, message = "username should have at least 2 characters")
    private String description;

    @NotNull
    @Min(1)
    private Long userId;
}
