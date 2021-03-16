package employeemanagerbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import employeemanagerbackend.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
	public Employee findByName(String name);
}

