package com.salesianos.triana.ComiendoPorTriana.comment.service;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.bar.repo.BarRepository;
import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.CommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.CreateCommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.model.dto.EditCommentDto;
import com.salesianos.triana.ComiendoPorTriana.comment.repo.CommentRepository;
import com.salesianos.triana.ComiendoPorTriana.exception.BarNotFoundException;
import com.salesianos.triana.ComiendoPorTriana.exception.CommentNotFoundException;
import com.salesianos.triana.ComiendoPorTriana.search.spec.GenericSpecificationBuilder;
import com.salesianos.triana.ComiendoPorTriana.search.util.SearchCriteria;
import com.salesianos.triana.ComiendoPorTriana.search.util.SearchCriteriaExtractor;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import com.salesianos.triana.ComiendoPorTriana.user.service.UserService;
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

    private final BarRepository barRepository;

    private final UserService userService;


    public CommentDto findById(UUID id) {
        Optional<Comment> opt = repo.findById(id);

        if(opt.isEmpty())
            throw new CommentNotFoundException("Comentario no encontrado");

        return CommentDto.of(opt.get());
    }


    public Page<Comment> findAll(String search, Pageable pageable, UUID id) {
        List<SearchCriteria> params = SearchCriteriaExtractor.extractSearchCriteriaList(search);
        params.add(new SearchCriteria("bar", ":", id));

        GenericSpecificationBuilder<Comment> specificationBuilder = new GenericSpecificationBuilder<>(params, Comment.class);
        Specification<Comment> spec =  specificationBuilder.build();

        Page<Comment> comments = repo.findAll(spec, pageable);

        if(comments.isEmpty())
            throw new CommentNotFoundException("No se encuentra ningún listado de comentarios.");

        return comments;
    }



    public Comment add(CreateCommentDto dto, UUID id){
        Optional<Bar> opt = barRepository.findById(id);

        if(opt.isEmpty())
            throw new BarNotFoundException("El Bar solicitado no ha sido encontrado.");

        Bar bar = opt.get();

        Comment comment = Comment.builder()
                                .title(dto.getTitle())
                                .text(dto.getText())
                                .author(dto.getAuthor())
                                .bar(dto.getBar())
                                .build();

        bar.getComments().add(comment);
        return comment;
    }


    public Comment edit(UUID barId, UUID comId, EditCommentDto dto, final User logged){
        Optional<Comment> opt = repo.findCommentFromBar(barId, comId);

        if (opt.isEmpty())
            throw new CommentNotFoundException("El comentario no existe");

        Comment comment = opt.get();
        //userService.checkCommentOwner(comment, logged.getId());
        comment.setTitle(dto.getTitle());
        comment.setText(dto.getText());
        return repo.save(comment);
    }


    public void delete(UUID barId, UUID comId, final User logged){
        Optional<Comment> opt = repo.findCommentFromBar(barId, comId);

        if (opt.isEmpty())
            throw new CommentNotFoundException("El comentario no existe");

        Comment comment = opt.get();
        //userService.checkCommentOwner(comment, logged.getId());
        repo.delete(comment);
    }

    public CommentDto findCommentFromBar(UUID barId, UUID commentID) {
        Optional<Comment> opt = repo.findCommentFromBar(barId, commentID);

        if(opt.isEmpty())
            throw new CommentNotFoundException("Comentario no encontrado");

        return CommentDto.of(opt.get());
    }


}
