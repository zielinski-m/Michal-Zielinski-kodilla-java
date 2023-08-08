package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Transactional
@ReadingConverter
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.lastname = :lastname")
    List<Employee> findEmployeesByLastName(String lastname);
}
