package com.example.paciente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

    @GetMapping("/index")
    public String welcome(Model model) {
        model.addAttribute("nombre", "Diego");
        model.addAttribute("apellido", "Maradona");
        model.addAttribute("numero", "10");
        return "index";
    }
}
