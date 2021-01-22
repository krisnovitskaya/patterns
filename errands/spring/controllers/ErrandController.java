package ru.krisnovitskaya.errandstm.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.krisnovitskaya.errandstm.dtos.ErrandDto;
import ru.krisnovitskaya.errandstm.services.ErrandService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/errand")
@RequiredArgsConstructor
public class ErrandController {
    private final ErrandService errandService;

    @GetMapping("/{id}")
    public List<ErrandDto> getAllByEmployeeId(@PathVariable Long id){
        return errandService.getAllByEmployeeId(id);
    }

    @GetMapping
    public List<ErrandDto> getCurrentErrands(){
        return errandService.getCurrentErrands();
    }

}
