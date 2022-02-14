package com.example.StreamBoot.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    //вызов страницы меню приложения
    @GetMapping("/")
    public String showMenu(){
        return "Start/menu";
    }
}
