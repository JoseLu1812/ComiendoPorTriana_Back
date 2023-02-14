package com.salesianos.triana.ComiendoPorTriana.comment.model.dto;

import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class CommentDto {

    @Column(name = "AUTHOR")
    private User author;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String text;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    public static CommentDto of(Comment c) {
        return CommentDto.builder()
                .author(c.getAuthor())
                .title(c.getTitle())
                .text(c.getText())
                .createdAt(c.getCreatedAt())
                .build();
    }

}
