package employeemanagerbackend.dto;

import lombok.Data;

@Data
public class EmployeeResponseDto {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String employeeCode;
}
