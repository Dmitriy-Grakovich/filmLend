package ru.grakovich.filmland.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
    @GetMapping("/error/404")
    public String get404Page(){
        return "errors/error_404";
    }
    @GetMapping("/error/403")
    public String get403Page(){
        return "errors/error_403";
    }

}
