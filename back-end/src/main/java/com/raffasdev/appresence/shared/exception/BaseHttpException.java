package com.raffasdev.appresence.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;

public abstract class BaseHttpException extends ErrorResponseException {

    protected BaseHttpException(HttpStatus status, String title, String detail, URI type, URI instance) {
        super(status, createProblemDetail(status, title, detail, type, instance), null);
    }

    private static ProblemDetail createProblemDetail(
            HttpStatus status, String title, String detail, URI type, URI instance) {

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, detail);
        problem.setTitle(title);
        problem.setType(type != null ? type : URI.create("about:blank"));
        if (instance != null)
            problem.setInstance(instance);
        return problem;
    }
}
