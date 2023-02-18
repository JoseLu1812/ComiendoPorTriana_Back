package com.salesianos.triana.ComiendoPorTriana.bar.controller;


import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.BarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.service.BarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public Page<Bar> search(@RequestParam(value = "search", defaultValue = "") String search,
                            @PageableDefault(size = 12, page = 0) Pageable pageable){
        return service.findAll(search, pageable);
    }



}
