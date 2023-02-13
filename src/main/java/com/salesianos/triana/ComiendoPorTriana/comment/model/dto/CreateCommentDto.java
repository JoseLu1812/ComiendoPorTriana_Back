package com.salesianos.triana.ComiendoPorTriana.comment.model.dto;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCommentDto {

    @Column(name = "BAR")
    private Bar bar;

    @Column(name = "USER")
    private User user;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "BODY")
    private String text;

    public static Comment ToComment(CreateCommentDto dto) {
        return Comment.builder()
                .title(dto.getTitle())
                .text(dto.getText())
                .bar(dto.getBar())
                .user(dto.getUser())
                .build();
    }


}
