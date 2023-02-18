package com.salesianos.triana.ComiendoPorTriana.comment.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EditCommentDto {

    private String title;

    private String text;

}
