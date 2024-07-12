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
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepositary repositary;

    @Override
    public void addemployee(Employee employee) {
        EmployeeEntity employeeEntity = new ObjectMapper().convertValue(employee, EmployeeEntity.class);
        repositary.save(employeeEntity);
    }

    @Override
    public List<Employee> getall() {
        List<Employee> employeeList = new ArrayList<>();
        List<EmployeeEntity> allEntityList = repositary.findAll();
         allEntityList.forEach(entity ->{
             employeeList.add(new ObjectMapper().convertValue(entity, Employee.class));
         });
         return employeeList;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if(repositary.existsById(id)){
            repositary.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if(repositary.findById(employee.getId()).isPresent()){
            repositary.save(new ObjectMapper().convertValue(employee ,  EmployeeEntity.class));
        }
    }

    @Override
    public Employee findById(Long id) {

       if(repositary.findById(id).isPresent()){
           Optional<EmployeeEntity> byId = repositary.findById(id);
           return new ObjectMapper().convertValue(byId.get(), Employee.class);
       }
       return new Employee();
    }
}
