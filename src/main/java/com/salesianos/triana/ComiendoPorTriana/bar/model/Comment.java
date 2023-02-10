package com.salesianos.triana.ComiendoPorTriana.bar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @JoinColumn(name = "bar_id", foreignKey = @ForeignKey(name = "FK_COMMENT_BAR"))
    @JsonIgnore
    @ManyToMany()
    private Bar bar;

    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_COMMENT_USER"))
    @JsonIgnore
    @ManyToOne
    private User user;

    private String title;

    @Column(name = "body")
    private String body;

    private LocalDateTime createdAt = LocalDateTime.now();




}
