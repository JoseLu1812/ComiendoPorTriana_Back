package com.salesianos.triana.ComiendoPorTriana.bar.repo;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BarRepository extends JpaRepository<Bar, UUID> {

    List<Bar>findByAuthor(String auhtor);

}
