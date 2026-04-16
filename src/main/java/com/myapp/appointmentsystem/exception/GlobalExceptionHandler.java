package com.myapp.appointmentsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResponseStatusException.class)
	public ApiError handleResponseStatusException(ResponseStatusException ex) {
        return new ApiError(
                ex.getStatusCode().value(),
                ex.getReason()
        );
	}
	
	 	
    @ExceptionHandler(Exception.class)
    public ApiError handleGenericException(Exception ex) {

        return new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unexpected error occurred"
        );
    }

	
}
