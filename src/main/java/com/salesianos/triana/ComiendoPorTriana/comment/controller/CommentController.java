package com.salesianos.triana.ComiendoPorTriana.comment.controller;

import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.CommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.CreateCommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.EditCommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.service.CommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@Tag(name = "Comment", description = "Controlador para manejar peticiones de objetos tipo Comment")
public class CommentController {

    private final CommentService service;

    @GetMapping("/")
    public Page<Comment> search(@RequestParam(value = "search", defaultValue = "") String search,
                                @PageableDefault(size = 12, page = 0) Pageable pageable){
        return service.findAll(search, pageable);
    }

    @GetMapping("/{id}")
    public CommentDto findByid(@PathVariable UUID id){
        return service.findById(id);
    }


    @PostMapping("/new")
    public ResponseEntity<CommentDto> createNewComment(@Valid @RequestBody CreateCommentDto dto){
        Comment comment = service.add(dto);
        URI createdURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(comment.getId()).toUri();

        return ResponseEntity
                .created(createdURI)
                .body(CommentDto.of(comment));
    }


    @PutMapping("/edit/{id}")
    public CommentDto edit(@PathVariable UUID id, @RequestBody EditCommentDto dto){
        return CommentDto.of(service.edit(id,dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
