package com.example.CrudOperation.controller;

import com.example.CrudOperation.dto.JWTAuthResponse;
import com.example.CrudOperation.dto.LoginDto;
import com.example.CrudOperation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Login {


    @Autowired
    EmployeeService employeeService;

    @PostMapping("/auth")
    public ResponseEntity<JWTAuthResponse> userLogin(@RequestBody LoginDto loginDto) {

        String accessToken = employeeService.login(loginDto, 1L);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(accessToken);

        return ResponseEntity.ok(jwtAuthResponse);
    }
}
