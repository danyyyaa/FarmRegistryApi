package ru.isands.farmregistryapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFound(final RuntimeException e) {
        log.debug("Получен статус 404 Not found {}", e.getMessage(), e);
        return createErrorResponse(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({AlreadyExistsException.class, NotAvailableException.class,
            DataIntegrityViolationException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleConflict(final RuntimeException e) {
        log.debug("Получен статус 409 Conflict {}", e.getMessage(), e);
        return createErrorResponse(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ValidationException.class, MethodArgumentTypeMismatchException.class,
            MethodArgumentNotValidException.class, MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleBadRequest(final RuntimeException e) {
        log.debug("Получен статус 400 Bad request {}", e.getMessage(), e);
        return createErrorResponse(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleRaw(final Throwable e) {
        log.debug("Получен статус 500 Internal server error {}", e.getMessage(), e);
        return createErrorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleConstraintViolationException(final ConstraintViolationException e) {
        log.debug("Получен статус 500 Internal server error {}", e.getMessage(), e);
        return Map.of(
                "error", e.getConstraintViolations()
                        .stream()
                        .map(ConstraintViolation::getMessageTemplate)
                        .findFirst()
                        .orElse("No message")
        );
    }

    private ApiError createErrorResponse(Throwable e, HttpStatus httpStatus) {
        return ApiError.builder()
                .message(e.getMessage())
                .reason(String.valueOf(e.getCause()))
                .status(httpStatus.name())
                .timestamp(LocalDateTime.now())
                .build();
    }
}

