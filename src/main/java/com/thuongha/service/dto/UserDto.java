package com.thuongha.service.dto;

import lombok.Data;

import java.io.Serializable;
import javax.validation.constraints.*;

@Data
public class UserDto implements Serializable {

    private static final Integer serialVersionUID = 1;

    @NotBlank(message = "The name is required")
    @Size(max = 255, message = "The name is over maximum length")
    private String userName;

    @NotNull(message = "The age is required")
    @Min(value = 1, message = "The duration in age must be greater than 1")
    @Max(value = 150, message = "The duration in age must be less than 150")
    private Integer age;

    @NotNull(message = "The email is required")
    private String email;
}
