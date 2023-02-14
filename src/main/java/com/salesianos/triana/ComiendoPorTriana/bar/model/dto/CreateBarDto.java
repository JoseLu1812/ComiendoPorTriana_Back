package com.salesianos.triana.ComiendoPorTriana.bar.model.dto;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
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


    private String name;

    private String description;

    private User owner;

    private String direction;

    private List<String> images;


    public static Bar toBar(CreateBarDto dto) {

        return Bar.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .owner(dto.getOwner())
                .direction(dto.getDirection())
                .images(dto.getImages())
                .build();
    }





}
