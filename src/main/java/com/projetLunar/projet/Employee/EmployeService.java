package com.projetLunar.projet.Employee;
import java.util.HashMap;
import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
public interface EmployeService {
    List<Employee> findAllEmployees();
    Employee addEmployee(EmployeeDto employee);
    Employee findByEmail(String email)throws NotFoundException;
    Employee findByName(String name)throws NotFoundException;
    Employee updateEmployee(String email,EmployeeDto dto) throws NotFoundException;
    void deleteEmployee(String email)throws NotFoundException;
    HashMap<String,Integer> getEmployeesNumberByPosition();
}
