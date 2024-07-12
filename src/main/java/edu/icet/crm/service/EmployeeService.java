package edu.icet.crm.service;

import edu.icet.crm.dto.Employee;

import java.util.List;

public interface EmployeeService {

void addemployee(Employee employee);

    List<Employee> getall();

    void deleteEmployeeById(Long id);

    void updateEmployee(Employee employee);

    Employee findById(Long id);

    Employee findByName(String name);
}
