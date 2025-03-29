package com.raffasdev.backend.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentPostRequestBody {
    private String name;
}
