package com.projetLunar.projet.Employee;
import java.time.LocalDate;
public record EmployeeDto(
    String name,
    String email,
    String position,
    LocalDate hiringDate
) {}
