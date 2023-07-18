package com.example.CrudOperation.service;

import com.example.CrudOperation.dto.EmployeeDto;
import com.example.CrudOperation.dto.LoginDto;
import com.example.CrudOperation.entity.Company;
import com.example.CrudOperation.entity.Employee;
import com.example.CrudOperation.repository.CompanyRepo;
import com.example.CrudOperation.repository.EmployeeRepo;
import com.example.CrudOperation.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    public Employee createEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        employee.setEmail(employeeDto.getEmail());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        Company company = new Company();
        Company companyExist = companyRepo.findByCompanyName(employeeDto.getCompanyName());
        if (companyExist != null) {
            employee.setCompany(companyExist);
        } else {
            company.setCompanyName(employeeDto.getCompanyName());
            employee.setCompany(company);
        }


        return employeeRepo.save(employee);


    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }

    public Employee updateEmployee(Long id, Employee employee) {

        Employee employee1 = employeeRepo.getReferenceById(id);
        employee1.setFirstName(employee.getFirstName());
        employee1.setEmail(employee.getEmail());
        employee1.setLastName(employee.getLastName());
        return employeeRepo.save(employee1);

    }


    public boolean deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
        return true;
    }


    public String login(LoginDto loginDto, long time) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication, time);
    }

    public Company createCompany(Company company) {
        return companyRepo.save(company);
    }

    public Employee updateEmployeeEmail(Long id, Employee emp) {
        Employee employee = employeeRepo.getReferenceById(id);
        employee.setEmail(emp.getEmail());
        return employeeRepo.save(employee);

    }
}
