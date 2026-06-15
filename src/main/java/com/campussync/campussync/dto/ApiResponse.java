package com.campussync.campussync.dto;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private int status;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    // Success response — with data
    public static <T> ApiResponse<T> success(T data, String message, int status) {
        ApiResponse<T> response = new ApiResponse<>();
        response.status    = status;
        response.message   = message;
        response.data      = data;
        response.timestamp = LocalDateTime.now();
        return response;
    }

    // Error response — no data
    public static <T> ApiResponse<T> error(String message, int status) {
        ApiResponse<T> response = new ApiResponse<>();
        response.status    = status;
        response.message   = message;
        response.data      = null;
        response.timestamp = LocalDateTime.now();
        return response;
    }

    // Getters
    public int getStatus()             { return status; }
    public String getMessage()         { return message; }
    public T getData()                 { return data; }
    public LocalDateTime getTimestamp(){ return timestamp; }
}