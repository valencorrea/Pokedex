package com.certant.pokedexRefactorValen.entrenador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class BaseController {

    @GetMapping({"/", ""})
    public String redireccionando() {
        return "redirect:entrenador/";
    }

    @GetMapping("/login")
    public String login(Model model, Principal principal, RedirectAttributes flash){
        if(principal!=null){
            flash.addFlashAttribute("info", "Ya ha iniciado sesión anteriormente");
            return "redirect:/";
        }
        return "login";
    }
}
