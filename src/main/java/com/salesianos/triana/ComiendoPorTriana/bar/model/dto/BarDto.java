package com.salesianos.triana.ComiendoPorTriana.bar.model.dto;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import lombok.*;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BarDto {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "DIRECTION")
    private String direction;

    @Column(name = "IMAGE")
    private List<String> images;

    public static BarDto of(Bar b) {
        return BarDto.builder()
                .name(b.getName())
                .description(b.getDescription())
                .author(b.getAuthor())
                .direction(b.getDirection())
                .images(b.getImages())
                .build();
    }

}
