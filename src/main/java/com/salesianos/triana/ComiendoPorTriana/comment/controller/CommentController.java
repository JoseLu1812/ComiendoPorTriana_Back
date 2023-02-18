package com.salesianos.triana.ComiendoPorTriana.comment.controller;

import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.comment.service.CommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
