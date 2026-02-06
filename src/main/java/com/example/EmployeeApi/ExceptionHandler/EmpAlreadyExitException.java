package com.example.EmployeeApi.ExceptionHandler;

public class EmpAlreadyExitException extends RuntimeException{
    public EmpAlreadyExitException(String message){
        super(message);
    }
}
