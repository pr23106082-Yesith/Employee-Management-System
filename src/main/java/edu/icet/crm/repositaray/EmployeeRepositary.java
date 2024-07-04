package edu.icet.crm.repositaray;

import edu.icet.crm.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepositary extends JpaRepository<EmployeeEntity ,Long> {
}
