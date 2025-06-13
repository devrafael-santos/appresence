package com.raffasdev.appresence.shared.exception.handler;

import com.raffasdev.appresence.identity.application.exception.EmailAlreadyExistsException;
import com.raffasdev.appresence.shared.exception.ApplicationException;
import com.raffasdev.appresence.shared.exception.DomainException;
import com.raffasdev.appresence.shared.exception.ErrorCode;
import com.raffasdev.appresence.shared.util.RequestUri;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ErrorResponseException.class)
    public ProblemDetail handleCustomExceptions(ErrorResponseException ex) {
        return ex.getBody();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String errors = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, errors);
        problem.setTitle(ErrorCode.VALIDATION_ERROR.getCode());
        problem.setType(URI.create(RequestUri.getBaseUrl(request) + "/error/validation"));
        problem.setInstance(URI.create(request.getRequestURI()));
        return problem;
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ProblemDetail> handleDomainException(
            DomainException ex, HttpServletRequest request) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        problem.setTitle(ErrorCode.DOMAIN_ERROR.getCode());
        problem.setType(URI.create(RequestUri.getBaseUrl(request) + "/error/domain"));
        problem.setInstance(URI.create(request.getRequestURI()));
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(problem);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ProblemDetail> handleApplicationException(
            ApplicationException ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        if (ex instanceof EmailAlreadyExistsException) {
            status = HttpStatus.CONFLICT;
        }

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, ex.getMessage());
        problem.setTitle(ErrorCode.VALIDATION_ERROR.getCode());
        problem.setType(URI.create(RequestUri.getBaseUrl(request) + "/error/application"));
        problem.setInstance(URI.create(request.getRequestURI()));
        return ResponseEntity.status(status).body(problem);
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGeneric(Exception ex, HttpServletRequest request) {
        ex.printStackTrace();

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR,
                "An unexpected error has occurred. Please try again later.");
        problem.setTitle(ErrorCode.INTERNAL_ERROR.getCode());
        problem.setType(URI.create(RequestUri.getBaseUrl(request) + "/error/internal"));
        problem.setInstance(URI.create(request.getRequestURI()));
        return problem;
    }
}
