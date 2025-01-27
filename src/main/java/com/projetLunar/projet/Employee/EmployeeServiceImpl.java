package com.projetLunar.projet.Employee;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeService {
    private final EmployeRepository repository;

    EmployeeServiceImpl(EmployeRepository repository) {
        this.repository = repository;
    }
    @Override
    public Employee addEmployee(EmployeeDto dto) {
        return this.repository.save(toEmployee(dto));
    }
    @Override
    public void deleteEmployee(String email) throws NotFoundException {
        Employee employee = this.repository.findByEmail(email);
        if (employee == null) {
            throw new NotFoundException();
        }
        String id = employee.getId();
        this.repository.deleteById(id);
    }
    @Override
    public List<Employee> findAllEmployees() {
        return this.repository.findAll();
    }
    @Override
    public Employee findByEmail(String email) throws NotFoundException {
        Employee employee = this.repository.findByEmail(email);
        if (employee == null) {
            throw new NotFoundException();
        }
        return employee;
    }
    @Override
    public Employee findByName(String name) throws NotFoundException {
        Employee employee = this.repository.findByName(name);
        if (employee == null) {
            throw new NotFoundException();
        }
        return employee;
    }
    @Override
    public HashMap<String, Integer> getEmployeesNumberByPosition() {
        HashMap<String, Integer> positionStatistics = new HashMap<>();
        List<Employee> employee = this.repository.findAll();
        for (int i = 0; i < employee.size(); i++) {
            if (positionStatistics.containsKey(employee.get(i).getPosition())) {
                positionStatistics.put(employee.get(i).getPosition(),
                        positionStatistics.get(employee.get(i).getPosition()) + 1);
            } else {
                positionStatistics.putIfAbsent(employee.get(i).getPosition(), 1);
            }
        }
        return positionStatistics;
    }
    @Override
    public Employee updateEmployee(String email, EmployeeDto dto) throws NotFoundException {
        Employee employee = findByEmail(email);
        if (employee == null) {
            throw new NotFoundException();
        } else {
            return this.repository.save(toEmployee(dto));
        }
    }
    private Employee toEmployee(EmployeeDto dto) {
        var employee = new Employee();
        employee.setEmail(dto.email());
        employee.setHiringDate(dto.hiringDate());
        employee.setName(dto.name());
        employee.setPosition(dto.position());
        return employee;
    }
}
