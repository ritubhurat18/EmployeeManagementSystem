package employeemanagerbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import employeemanagerbackend.dto.EmployeeDto;
import employeemanagerbackend.dto.EmployeeResponseDto;
import employeemanagerbackend.service.EmployeeServiceImpl;


@RestController
public class EmployeeController {
	@Autowired
    private EmployeeServiceImpl employeeService;
    
    
	@CrossOrigin
    @PostMapping("/save_employee")
    @ResponseStatus(HttpStatus.CREATED)
    
    public EmployeeResponseDto createEmployee(@RequestBody EmployeeDto employeeDto)
    {
		return this.employeeService.createEmployee(employeeDto);
    }
    
    @GetMapping("/search/{id}")
    public EmployeeResponseDto getEmployeeById(@PathVariable("id") int employeeId)
    {
		return this.employeeService.getEmployeeById(employeeId);
    	
    }
    @GetMapping("/search/{name}")
    public EmployeeResponseDto getEmployeeById(@PathVariable("name") String name)
    {
		return this.employeeService.getEmployeeByName(name);
    	
    }
    
    @CrossOrigin
    @GetMapping("/search")
    public List<EmployeeResponseDto> getAllEmployees()
    {
    	return this.employeeService.getAllEmployees();
    }
    
    @PutMapping("/update/{id}")
    public EmployeeResponseDto updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable("id") int employeeId)
    {
    	return this.employeeService.updateEmployee(employeeDto,employeeId);
    }
   
    @DeleteMapping("/employee/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int employeeId)
    {
    	this.employeeService.deleteEmployee(employeeId);
    }

}
