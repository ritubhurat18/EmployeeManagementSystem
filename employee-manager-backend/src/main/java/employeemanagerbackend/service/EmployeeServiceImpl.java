package employeemanagerbackend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import employeemanagerbackend.dto.DtoConverter;
import employeemanagerbackend.dto.EmployeeDto;
import employeemanagerbackend.dto.EmployeeResponseDto;
import employeemanagerbackend.exception.RecordNotFoundException;
import employeemanagerbackend.model.Employee;
import employeemanagerbackend.repository.EmployeeRepo;

@Component
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepo employeeRepository;
	@Autowired
	private DtoConverter dtoConverter;

	@Override
	public EmployeeResponseDto createEmployee(EmployeeDto employeeDto) {
		Employee employee =dtoConverter.dtoToEntity(employeeDto);
		employee.setEmployeeCode(UUID.randomUUID().toString());
		this.employeeRepository.save(employee);
		return dtoConverter.entityToDto(employee);
	} 

	@Override
	public EmployeeResponseDto getEmployeeById(int employeeId) {
		Employee employee = this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new RecordNotFoundException("Employee not found for this id : " + employeeId));
		
		EmployeeResponseDto dto;
		dto = this.dtoConverter.entityToDto(employee);
		return dto;
	}

	@Override
	public List<EmployeeResponseDto> getAllEmployees() {
		
		List<Employee> list;
		List<EmployeeResponseDto> dto;
		list = this.employeeRepository.findAll();
		dto = this.dtoConverter.entityToDto(list);
		if (list.isEmpty())
			throw new RecordNotFoundException("There is no Employees to display");
		return dto;
	}

	@Override
	public EmployeeResponseDto updateEmployee(EmployeeDto employeeDto, int employeeId) {
		
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new RecordNotFoundException("Employee not found for this id :: " + employeeId));
		 employee.setEmail( employeeDto.getEmail());
		 employee.setAddress( employeeDto.getAddress());
		 employee.setPhone( employeeDto.getPhone());
		
		final Employee updatedemployee =  employeeRepository.save(employee);
		
		return this.dtoConverter.entityToDto(updatedemployee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		Employee employee = this.employeeRepository.findById(employeeId)
				.orElseThrow(() -> new RecordNotFoundException("No employee exists for this id :: " + employeeId));
		if (employee != null)
			this.employeeRepository.deleteById(employeeId);
	}

	@Override
	public EmployeeResponseDto getEmployeeByName(String name) {
		Employee employee=this.employeeRepository.findByName(name);
		if(employee==null)
		{
			throw new RecordNotFoundException("No Employees exists with this name::"+name);
		}
		return this.dtoConverter.entityToDto(employee) ;
	}

	
	
}
