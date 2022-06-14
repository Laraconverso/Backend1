package com.example.Spring_Final.controller;

import com.example.Spring_Final.dao.impl.OdontologoDaoH2;
import com.example.Spring_Final.model.Odontologo;
import com.example.Spring_Final.service.OdontologoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/odontologos")
    public class OdontologoController {

        private OdontologoService odontologoService=new OdontologoService(new OdontologoDaoH2());

        @GetMapping("/{id}")
        public Odontologo buscarPorId(@PathVariable("id") Integer id){
            return odontologoService.buscar(id);
        }

        @GetMapping
        public List<Odontologo> buscarOdontologos(){
            return odontologoService.buscarTodos();
        }
    }
