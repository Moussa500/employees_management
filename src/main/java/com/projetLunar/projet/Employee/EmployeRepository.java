package com.projetLunar.projet.Employee;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface EmployeRepository extends MongoRepository<Employee,String> {
    Employee findByName(String nom);
    Employee findByEmail(String email);
    boolean deleteByEmail(String email);
    List<Employee> findByPosition(String position);
}
