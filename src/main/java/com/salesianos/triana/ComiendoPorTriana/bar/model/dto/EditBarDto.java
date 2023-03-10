package com.salesianos.triana.ComiendoPorTriana.bar.model.dto;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EditBarDto {

    private String name;

    private String description;

    private String direction;

    private String image;


    public static EditBarDto of(Bar b) {
        return EditBarDto.builder()
                .name(b.getName())
                .description(b.getDescription())
                .direction(b.getDirection())
                .image(b.getImage())
                .build();
    }

    public static Bar toBar(EditBarDto dto) {
        return Bar.builder()
                .name(dto.name)
                .description(dto.getDescription())
                .direction(dto.getDirection())
                .image(dto.getImage())
                .build();
    }

}
