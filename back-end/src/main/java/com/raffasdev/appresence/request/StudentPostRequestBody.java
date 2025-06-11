package com.raffasdev.appresence.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentPostRequestBody {

    @NotEmpty(message = "The Student name cannot be empty")
    private String name;
}
