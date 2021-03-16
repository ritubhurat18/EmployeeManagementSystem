package employeemanagerbackend.service;


import java.util.List;

import org.springframework.stereotype.Service;

import employeemanagerbackend.dto.EmployeeDto;
import employeemanagerbackend.dto.EmployeeResponseDto;



@Service
public interface EmployeeService   {
	public EmployeeResponseDto createEmployee(EmployeeDto employeeDto);
	public EmployeeResponseDto getEmployeeById(int employeeId);
	public List<EmployeeResponseDto> getAllEmployees();
	public EmployeeResponseDto updateEmployee(EmployeeDto employeeDto,int employeeId);
	public void deleteEmployee(int employeeId);
	public EmployeeResponseDto getEmployeeByName(String name);
	
}
