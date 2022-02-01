package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.service.MyService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
    
    private MyService service;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("time", service.getTime());
    
        return "home";
    }   
}
