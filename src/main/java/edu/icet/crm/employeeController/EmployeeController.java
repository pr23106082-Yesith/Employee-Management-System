package edu.icet.crm.employeeController;

import edu.icet.crm.dto.Employee;
import edu.icet.crm.entity.EmployeeEntity;
import edu.icet.crm.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {

 final EmployeeService service;

@PostMapping("/add-employee")
public void addEmployee(@RequestBody Employee employee){
    service.addemployee(employee);
}

@GetMapping("/get-emp")
public List<EmployeeEntity> getall(){
    return service.getall();
}
    
}
