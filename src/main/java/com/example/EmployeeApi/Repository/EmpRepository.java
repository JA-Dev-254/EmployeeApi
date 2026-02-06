package com.example.EmployeeApi.Repository;

import com.example.EmployeeApi.Entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer> {
    public Optional<Emp> findByEname(String ename);

}
