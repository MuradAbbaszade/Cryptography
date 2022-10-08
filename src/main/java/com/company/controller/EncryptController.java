package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("index")
public class EncryptController {
    @GetMapping
    public String showEncryptPage(Model model){
        List<String> algorithims = Arrays.asList("Affine","Caesar","Viginere");
        model.addAttribute("algorithims",algorithims);
        return "index";
    }
}
