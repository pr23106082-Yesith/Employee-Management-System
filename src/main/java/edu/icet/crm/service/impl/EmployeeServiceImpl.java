package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.dto.Employee;
import edu.icet.crm.entity.EmployeeEntity;
import edu.icet.crm.repositaray.EmployeeRepositary;
import edu.icet.crm.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepositary employeeRepositary;

    @Override
    public void addemployee(Employee employee) {
        EmployeeEntity employeeEntity = new ObjectMapper().convertValue(employee, EmployeeEntity.class);
        employeeRepositary.save(employeeEntity);
    }

    @Override
    public List<Employee> getall() {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> allEntityList = employeeRepositary.findAll();
         allEntityList.forEach(entity ->{
             employeeList.add(new ObjectMapper().convertValue(entity, Employee.class));
         });
         return employeeList;
    }
}
