package employeemanagerbackend.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import employeemanagerbackend.model.Employee;

@Component
public class DtoConverter {
	public Employee dtoToEntity(EmployeeDto employeeDto) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(employeeDto, Employee.class);

	}
	public EmployeeResponseDto entityToDto(Employee employee) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(employee, EmployeeResponseDto.class);

	}
	public List<EmployeeResponseDto> entityToDto(List<Employee> employees) {

		return employees.stream().map(m -> entityToDto(m)).collect(Collectors.toList());
	}
	public List<Employee> dtoToEntity(List<EmployeeDto> employeeDto) {
		return employeeDto.stream().map(m -> dtoToEntity(m)).collect(Collectors.toList());

	}
}
