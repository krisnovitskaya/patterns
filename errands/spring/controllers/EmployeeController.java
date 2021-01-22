package ru.krisnovitskaya.errandstm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.krisnovitskaya.errandstm.dtos.EmployeeDto;
import ru.krisnovitskaya.errandstm.entities.Employee;
import ru.krisnovitskaya.errandstm.exceptions.ResourceNotFoundException;
import ru.krisnovitskaya.errandstm.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;


    @GetMapping(value = "/{id}", produces = "application/json")
    public EmployeeDto findById(Long id) {

        return employeeService.findById(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> create(@RequestBody Employee newEmployee, @RequestParam Long departmentId) {
        employeeService.saveNewEmployee(newEmployee, departmentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> update(@RequestBody EmployeeDto changedEmployee, String departmentTitle) {
        employeeService.updateEmployee(changedEmployee, departmentTitle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(Long id) {
        employeeService.delete(id);

        return new ResponseEntity(HttpStatus.OK);

    }
}
