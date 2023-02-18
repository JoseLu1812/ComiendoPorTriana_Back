package com.salesianos.triana.ComiendoPorTriana.comment.repo;

import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CommentRepository extends JpaRepository<Comment, Long>, JpaSpecificationExecutor<Comment> {



}
