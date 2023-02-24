package com.salesianos.triana.ComiendoPorTriana.bar.model.dto;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.comment.model.Comment;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import lombok.*;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BarDto {

    private String name;

    private String description;

    private User owner;

    private String direction;

    private List<Comment> comments;

    private String image;

    public static BarDto of(Bar b) {
        return BarDto.builder()
                .name(b.getName())
                .description(b.getDescription())
                .owner(b.getOwner())
                .direction(b.getDirection())
                .comments(b.getComments())
                .image(b.getImage())
                .build();
    }

}
