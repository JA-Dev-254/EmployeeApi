package com.example.EmployeeApi.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NoSuchEmpexistsException.class)
    public ResponseEntity<Response> handleNoSuchEmpexistsException(NoSuchEmpexistsException empexistsException){

        Response error = new Response(HttpStatus.NOT_FOUND.value(), empexistsException.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = EmpAlreadyExitException.class)
    public ResponseEntity<Response> handleEmpAlreadyExitException(EmpAlreadyExitException empAlreadyExitException){

        Response error = new Response(HttpStatus.CONFLICT.value(), empAlreadyExitException.getMessage());
        return new ResponseEntity<>(error,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){

       Map<String,String> errors = new HashMap<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError error: fieldErrors){
            errors.put(error.getField(),error.getDefaultMessage());
        }
        return  new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Response> handleException(Exception exception){

        Response error = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage());
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
