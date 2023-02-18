package com.salesianos.triana.ComiendoPorTriana.comment.service;

import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
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

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository repo;
    public Page<Comment> findAll(String search, Pageable pageable) {
        List<SearchCriteria> params = SearchCriteriaExtractor.extractSearchCriteriaList(search);

        GenericSpecificationBuilder<Comment> specificationBuilder = new GenericSpecificationBuilder<>(params, Comment.class);
        Specification<Comment> spec =  specificationBuilder.build();

        Page<Comment> comments = repo.findAll(spec, pageable);

        if(comments.isEmpty())
            throw new CommentNotFoundException("No se encuentra ningún listado de comentarios.");

        return comments;
    }

}
