package com.example.classtask.serviceimpl;

import com.example.classtask.api.ApiResponse;
import org.springframework.http.ResponseEntity;

public class ApiResponseBuilder {
    public static <T> ResponseEntity<ApiResponse<T>> buildResponseEntity(ApiResponse<T> response) {
        return new ResponseEntity<>(response, response.getStatus());
    }
}
