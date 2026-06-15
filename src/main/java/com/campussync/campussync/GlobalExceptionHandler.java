package com.campussync.campussync;

import com.campussync.campussync.dto.ApiResponse;
import com.campussync.campussync.exception.BadRequestException;
import com.campussync.campussync.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // handles ResourceNotFoundException → 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleNotFound(
            ResourceNotFoundException ex) {

        ApiResponse<?> response = ApiResponse.error(
                ex.getMessage(), 404);

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    // handles BadRequestException → 400
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<?>> handleBadRequest(
            BadRequestException ex) {

        ApiResponse<?> response = ApiResponse.error(
                ex.getMessage(), 400);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    // handles any other unexpected exception → 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGeneral(
            Exception ex) {

        ApiResponse<?> response = ApiResponse.error(
                "Something went wrong. Please try again.", 500);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}