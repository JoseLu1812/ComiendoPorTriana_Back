package com.salesianos.triana.ComiendoPorTriana.bar.controller;


import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.BarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.service.BarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bar")
@Tag(name = "Bar", description = "Controlador para manejar peticiones de objetos tipo Bar")
public class BarController {

    private final BarService service;

    @GetMapping("/{id}")
    public BarDto searchById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping()
    public List<BarDto> searchAll(){
        return service.findAll();
    }

}
