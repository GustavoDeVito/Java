package br.com.java.post.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
  @NotEmpty
  @Size(min = 2, message = "name should have at least 2 characters")
  private String name;

  @NotEmpty
  @Size(min = 3, message = "username should have at least 3 characters")
  private String username;

  @NotEmpty
  // create validation and hash to field
  private String password;

  @Max(value = 100, message = "Age must not be greater than 100")
  @Min(value = 18, message = "Age must not be lesser than 18")
  private Integer age;

  private Boolean isActive = true;
}
