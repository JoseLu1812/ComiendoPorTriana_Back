package com.salesianos.triana.ComiendoPorTriana.bar.model;

import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name="BAR_ENTITY")
public class Bar {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "DIRECTION")
    private String direction;

    @Column(name = "IMAGE")
    @Builder.Default
    private List<String> images = new ArrayList<String>();

    @Column(name = "COMMENTS")
    @Builder.Default
    private List<Comment> comments = new ArrayList<Comment>();

    @Column(name = "CREATED_AT")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

}
