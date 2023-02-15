package com.salesianos.triana.ComiendoPorTriana.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue
    private UUID id;

    @JoinColumn(name = "BAR")
    @JsonIgnore
    @ManyToOne()
    private Bar bar;

    @JoinColumn(name = "AUTHOR")
    @JsonIgnore
    @ManyToOne()
    @CreatedBy
    private User author;

    private String title;

    private String text;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();




}
