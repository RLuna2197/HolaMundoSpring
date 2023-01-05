package com.spring.hm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@Slf4j
public class Controlador {
    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        var mensaje = "Hola mundo con Thymeleaf";
        var persona = new Persona();
        persona.setNombre("juan");
        persona.setApellido("perez");
        persona.setEmail("preuba@gmail.com");
        persona.setTelefono("2252522");

        var persona2 = new Persona();
        persona2.setNombre("Roberto");
        persona2.setApellido("perez");
        persona2.setEmail("preuba2@gmail.com");
        persona2.setTelefono("7252522");

        var personas = Arrays.asList(persona, persona2);

        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);

        return  "index";
    }
}
