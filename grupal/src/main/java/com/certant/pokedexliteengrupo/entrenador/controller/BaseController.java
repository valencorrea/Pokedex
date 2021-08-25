package com.certant.pokedexliteengrupo.entrenador.controller;

import com.certant.pokedexliteengrupo.entrenador.entity.Entrenador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

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
