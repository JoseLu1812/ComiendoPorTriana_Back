package com.salesianos.triana.ComiendoPorTriana.comment.controller;

import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.BarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.service.BarService;
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
@Tag(name = "Comment", description = "Controlador para manejar peticiones de objetos tipo Comment")
public class CommentController {

    private final CommentService service;

    private final BarService barService;

    @GetMapping("/bar/{barId}/comment/")
    public Page<Comment> searchBarComments(@RequestParam(value = "search", defaultValue = "") String search,
                                           @PageableDefault(size = 12, page = 0) Pageable pageable,
                                           @PathVariable UUID barId){
        return service.findAll(search, pageable, barId);
    }

    @GetMapping("/bar/{barId}/comment/{comId}")
    public CommentDto findBarComment(@PathVariable UUID barId, @PathVariable UUID comId){
        BarDto bar = barService.findById(barId);

        return service.findCommentFromBar(barId, comId);
    }


    @PostMapping("bar/{barId}/comment/")
    public ResponseEntity<CommentDto> createNewComment(@Valid @RequestBody CreateCommentDto dto, @PathVariable UUID barId){
        Comment comment = service.add(dto, barId);
        URI createdURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(comment.getId()).toUri();

        return ResponseEntity
                .created(createdURI)
                .body(CommentDto.of(comment));
    }


    @PutMapping("bar/{barId}/comment/{comId}")
    public CommentDto edit(@PathVariable UUID comId, @PathVariable UUID barId, @RequestBody EditCommentDto dto){
        return CommentDto.of(service.edit(barId,comId,dto));
    }

    @DeleteMapping("bar/{barId}/comment/{comId}")
    public ResponseEntity<?> delete(@PathVariable UUID comId, @PathVariable UUID barId){
        service.delete(barId,comId);
        return ResponseEntity.noContent().build();
    }


}
