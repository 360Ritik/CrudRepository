package com.example.CrudOperation.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {
    Long id;
    String companyName;
    private String firstName;
    private String lastName;
    private String email;

}
