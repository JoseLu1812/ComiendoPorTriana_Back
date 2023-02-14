package com.salesianos.triana.ComiendoPorTriana.comment.model.dto;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Max;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCommentDto {

    private Bar bar;

    private User author;

    @Max(value=50, message = "{createCommentDto.title.max}")
    private String title;

    @Max(value=200, message = "{createCommentDto.text.max}")
    private String text;

    public static Comment ToComment(CreateCommentDto dto) {
        return Comment.builder()
                .title(dto.getTitle())
                .text(dto.getText())
                .bar(dto.getBar())
                .author(dto.getAuthor())
                .build();
    }


}
