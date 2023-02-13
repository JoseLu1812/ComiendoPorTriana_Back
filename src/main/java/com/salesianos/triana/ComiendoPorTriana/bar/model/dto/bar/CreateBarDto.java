package com.salesianos.triana.ComiendoPorTriana.bar.model.dto.bar;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBarDto {


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


    public static Bar toBar(CreateBarDto dto) {

        return Bar.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .author(dto.getAuthor())
                .direction(dto.getDirection())
                .images(dto.getImages())
                .build();
    }





}
