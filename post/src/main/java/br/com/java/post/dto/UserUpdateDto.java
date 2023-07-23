package br.com.java.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
    // create validation and hash to field
    private String password;

    // create validation
    private Boolean isActive;
}
