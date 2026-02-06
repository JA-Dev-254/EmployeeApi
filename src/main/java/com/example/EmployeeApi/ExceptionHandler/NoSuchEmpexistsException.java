package com.example.EmployeeApi.ExceptionHandler;

public class NoSuchEmpexistsException extends RuntimeException{
    public NoSuchEmpexistsException(String message){
        super(message);
    }
}
