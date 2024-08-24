package com.sistema.biblioteca.controller;

import com.sistema.biblioteca.entity.Prestamo;
import com.sistema.biblioteca.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
    private PrestamoService prestamoService;
    @Autowired
    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }
    @PostMapping("/save")
    public Prestamo save(@RequestBody Prestamo prestamo) {
        return prestamoService.save(prestamo);
    }
}
