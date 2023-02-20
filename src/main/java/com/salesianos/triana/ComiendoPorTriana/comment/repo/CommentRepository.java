package com.salesianos.triana.ComiendoPorTriana.comment.repo;

import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID>, JpaSpecificationExecutor<Comment> {

    @Query("""
            select c
            from Comment c
            where c.bar.id = :bar and c.id = :comment
            """)
    public Optional<Comment> findCommentFromBar(@Param("bar") UUID bar, @Param("comment") UUID comment);


}
