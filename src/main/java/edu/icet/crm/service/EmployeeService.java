package edu.icet.crm.service;

import edu.icet.crm.dto.Employee;

import java.util.List;

public interface EmployeeService {

void addemployee(Employee employee);

List<Employee> getall();

}
