package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM COMPANIES WHERE SUBSTRING(COMPANY_NAME, 1, 3) = :prefix")
    List<Company> findCompaniesByFirstThreeCharacters(String prefix);

    @Query(nativeQuery = true, value = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE :fragment")
    List<Company> findCompanyByNameFragment(String fragment);
}
