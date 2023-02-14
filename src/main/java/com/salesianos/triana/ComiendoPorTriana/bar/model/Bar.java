package com.salesianos.triana.ComiendoPorTriana.bar.model;

import com.salesianos.triana.ComiendoPorTriana.bar.model.converter.StringListConverter;
import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
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
public class Bar {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String description;

    @ManyToOne
    private User owner;

    private String direction;

    @Builder.Default
    @Convert(converter = StringListConverter.class)
    private List<String> images = new ArrayList<String>();

    @Builder.Default
    @OneToMany(mappedBy = "bar")
    private List<Comment> comments = new ArrayList<Comment>();

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

}
