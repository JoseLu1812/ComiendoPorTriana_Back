package com.salesianos.triana.ComiendoPorTriana.bar.controller;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.BarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.CreateBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.EditBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.service.BarService;
import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.CommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.service.CommentService;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bar")
@Tag(name = "Bar", description = "Controlador para manejar peticiones de objetos tipo Bar")
public class BarController {

    private final BarService service;

    private final CommentService commentService;

    @GetMapping("/{id}")
    public BarDto findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/")
    public Page<Bar> search(@RequestParam(value = "search", defaultValue = "") String search,
                            @PageableDefault(size = 12, page = 0) Pageable pageable){
        return service.findAll(search, pageable);
    }

    @PostMapping("/new")
    public ResponseEntity<BarDto> createNewBar(@AuthenticationPrincipal User logged, @Valid @RequestBody CreateBarDto dto) {
        Bar bar = service.add(dto, logged);
        URI createdURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(bar.getId()).toUri();

        return ResponseEntity
                .created(createdURI)
                .body(BarDto.of(bar));
    }


    @PutMapping("/edit/{id}")
    public BarDto edit(@AuthenticationPrincipal User logged, @PathVariable UUID id, @RequestBody EditBarDto dto) {
        return BarDto.of(service.edit(id,dto, logged));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@AuthenticationPrincipal User logged, @PathVariable UUID id) {
        service.delete(id, logged);

        return ResponseEntity.noContent().build();
    }


}
