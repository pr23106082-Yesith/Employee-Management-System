package edu.icet.crm.service;

import edu.icet.crm.dto.Employee;
import edu.icet.crm.entity.EmployeeEntity;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {

void addemployee(Employee employee);

List<EmployeeEntity> getall();

}
