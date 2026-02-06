package com.example.EmployeeApi.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class EmpDto {
    @Size(min = 1 , message = "Ename can't be empty")
    private String ename;
    @Min(value = 10000 , message = "salary at least 10000")
    private Double sal;
}
