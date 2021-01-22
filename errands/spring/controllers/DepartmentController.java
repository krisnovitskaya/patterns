package ru.krisnovitskaya.errandstm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.krisnovitskaya.errandstm.dtos.DepartmentDto;
import ru.krisnovitskaya.errandstm.services.DepartmentService;

import java.util.List;

@RestController
@RequestMapping(name = "/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping(produces = "application/json")
    public List<DepartmentDto> getAll() {
        return departmentService.getAll();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(Long id) {
        if (departmentService.deleteById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
