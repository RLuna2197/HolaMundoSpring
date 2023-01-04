package com.spring.hm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("persona", persona);

        return  "index";
    }
}
