package com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.controller;

import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.entity.Evolucion;
import com.certant.pokedexRefactorValen.pokemon.atributosPokemon.evolucion.service.IEvolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pokemon/evolucion")
public class EvolucionController {
    @Autowired
    IEvolucionService evolucionService;

    @ResponseBody
    @GetMapping("/")
    //public String findAll(Model model){
    public List<Evolucion> findAll(Model model){
        List<Evolucion> evoluciones = evolucionService.findAll();
        model.addAttribute("title","Lista de evoluciones");
        model.addAttribute("evoluciones", evoluciones);
        //return "evolucion/findAll";
        return  evoluciones;
    }
}