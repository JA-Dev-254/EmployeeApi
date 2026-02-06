package com.example.EmployeeApi.Service;

import com.example.EmployeeApi.Dto.EmpDto;
import com.example.EmployeeApi.Entity.Emp;
import com.example.EmployeeApi.ExceptionHandler.EmpAlreadyExitException;
import com.example.EmployeeApi.ExceptionHandler.NoSuchEmpexistsException;
import com.example.EmployeeApi.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    private EmpRepository empRepository;

    @Autowired
    public EmpService(EmpRepository empRepository){
        this.empRepository=empRepository;
    }

    public String EmpAdd(Emp emp){
        Emp e=empRepository.findByEname(emp.getEname()).orElse(null);
        if (e!=null){
            throw new EmpAlreadyExitException("Employee with "+ emp.getEname() +" already exists");
        }
        empRepository.save(emp);
        return "Employee Add successfully";
    }
    public Emp getEmp(Integer empId){
       Emp e= empRepository.findById(empId).orElse(null);
       if (e==null){
           throw new NoSuchEmpexistsException("Employee with Id "+ empId +" does not exists");
       }
       return e;
    }

    public String UpdateEmp(EmpDto empDto , Integer empId){
        Emp e= empRepository.findById(empId).orElse(null);
        if (e==null){
            throw new NoSuchEmpexistsException("Employee with Id"+ empId +"does not exists");
        }
if (empDto.getEname()!=null) {
    e.setEname(empDto.getEname());
}
if (empDto.getEname()!=null) {
    e.setSal(empDto.getSal());
}
        empRepository.save(e);
                return"Employee Update successfully";
    }
}


