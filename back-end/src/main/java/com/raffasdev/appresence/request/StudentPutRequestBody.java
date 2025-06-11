package com.raffasdev.appresence.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentPutRequestBody {

    @NotBlank(message = "The Student name cannot be empty")
    private String name;
}
