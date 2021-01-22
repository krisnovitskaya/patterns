package ru.krisnovitskaya.errandstm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.krisnovitskaya.errandstm.dtos.ErrandSimpleDto;
import ru.krisnovitskaya.errandstm.services.ErrandService;

import java.util.List;


@Controller
@RequestMapping("/current")
@RequiredArgsConstructor
public class SecurityPostErrandController {
    private final ErrandService errandService;


    @GetMapping
    public String getCurrentErrands(Model model){
        List<ErrandSimpleDto> errands = errandService.getCurrentForPostSecurity();
        model.addAttribute("errands", errands);
        return "errands";
    }

}
