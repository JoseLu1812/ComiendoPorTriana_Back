package com.salesianos.triana.ComiendoPorTriana.bar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import lombok.*;
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
@Table(name="COMMENT_ENTITY")
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private UUID id;

    @JoinColumn(name = "BAR")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Bar bar;

    @JoinColumn(name = "USER")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String text;

    @Column(name = "CREATED_AT")
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();




}
