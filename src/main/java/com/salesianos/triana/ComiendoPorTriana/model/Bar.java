package com.salesianos.triana.ComiendoPorTriana.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Bar {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String calle;
    private String imagen;
    private int valoracion;
    private boolean favorito;



}
