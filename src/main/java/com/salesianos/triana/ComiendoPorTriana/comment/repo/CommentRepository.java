package com.salesianos.triana.ComiendoPorTriana.comment.repo;

import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID>, JpaSpecificationExecutor<Comment> {



}
