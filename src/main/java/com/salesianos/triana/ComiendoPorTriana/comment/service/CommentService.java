package com.salesianos.triana.ComiendoPorTriana.comment.service;

import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.CommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.CreateCommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.EditCommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.repo.CommentRepository;
import com.salesianos.triana.ComiendoPorTriana.exception.CommentNotFoundException;
import com.salesianos.triana.ComiendoPorTriana.search.spec.GenericSpecificationBuilder;
import com.salesianos.triana.ComiendoPorTriana.search.util.SearchCriteria;
import com.salesianos.triana.ComiendoPorTriana.search.util.SearchCriteriaExtractor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repo;


    public CommentDto findById(UUID id) {
        Optional<Comment> opt = repo.findById(id);

        if(opt.isEmpty())
            throw new CommentNotFoundException("Comentario no encontrado");

        return CommentDto.of(opt.get());
    }


    public Page<Comment> findAll(String search, Pageable pageable) {
        List<SearchCriteria> params = SearchCriteriaExtractor.extractSearchCriteriaList(search);

        GenericSpecificationBuilder<Comment> specificationBuilder = new GenericSpecificationBuilder<>(params, Comment.class);
        Specification<Comment> spec =  specificationBuilder.build();

        Page<Comment> comments = repo.findAll(spec, pageable);

        if(comments.isEmpty())
            throw new CommentNotFoundException("No se encuentra ningún listado de comentarios.");

        return comments;
    }


    public Comment add(CreateCommentDto dto){
        return repo.save(Comment.builder()
                        .title(dto.getTitle())
                        .text(dto.getText())
                        .author(dto.getAuthor())
                        .bar(dto.getBar())
                        .build());
    }


    public Comment edit(UUID id, EditCommentDto dto){
        return repo.findById(id)
                .map(comment -> {
                    comment.setTitle(dto.getTitle());
                    comment.setText(dto.getText());
                    return repo.save(comment);
                })
                .orElseThrow(() -> new CommentNotFoundException("El comentario no existe"));
    }


    public void delete(UUID id){
        if(repo.existsById(id))
            repo.deleteById(id);
    }


}
