package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class FacadeTestSuite {

    @Autowired
    private FacadeSearcher facadeSearcher;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findCompanyByNameFragment() {

        //Given
        Company company1 = new Company("Kodilla Company");
        Company company2 = new Company("The Godzilla Corporation");
        companyDao.save(company1);
        companyDao.save(company2);

        //When
        List<Company> foundCompanies = facadeSearcher.searchCompaniesByFragment("Kod");

        //Then
        assertEquals(1, foundCompanies.size());
        assertEquals("Kodilla Company", foundCompanies.get(0).getName());
    }

    @Test
    public void findEmployeeByNameFragment() {

        //Given
        Employee employee1 = new Employee("Adam", "First");
        Employee employee2 = new Employee("Jacob", "Second");

        employeeDao.save(employee1);
        employeeDao.save(employee2);

        //When
        List<Employee> foundEmployeeName = facadeSearcher.employeesByNameFragment("Jacob");

        //Then
        assertEquals(1, foundEmployeeName.size());
        assertEquals("Jacob", foundEmployeeName.get(0).getFirstname());
        assertEquals("Second", foundEmployeeName.get(0).getLastname());
    }
}
