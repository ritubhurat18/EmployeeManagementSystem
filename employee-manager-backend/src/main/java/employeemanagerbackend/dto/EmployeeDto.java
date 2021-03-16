package employeemanagerbackend.dto;


import lombok.Data;

@Data
public class EmployeeDto {
	private String name;
	private String email;
	private String phone;
	private String address;
	private String password;
}
