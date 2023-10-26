package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacadeSearcher {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public FacadeSearcher(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> searchCompaniesByFragment(String fragment) {
        return companyDao.findCompanyByNameFragment("%" + fragment + "%");
    }

    public List<Employee> employeesByNameFragment(String fragment) {
        return employeeDao.findByEmployeeNameFragment("%" + fragment + "%");
    }
}
