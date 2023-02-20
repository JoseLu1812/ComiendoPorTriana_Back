package com.salesianos.triana.ComiendoPorTriana.bar.service;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.BarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.CreateBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.EditBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.repo.BarRepository;
import com.salesianos.triana.ComiendoPorTriana.exception.BarNotFoundException;
import com.salesianos.triana.ComiendoPorTriana.search.spec.GenericSpecificationBuilder;
import com.salesianos.triana.ComiendoPorTriana.search.util.SearchCriteria;
import com.salesianos.triana.ComiendoPorTriana.search.util.SearchCriteriaExtractor;
import com.salesianos.triana.ComiendoPorTriana.user.model.User;
import com.salesianos.triana.ComiendoPorTriana.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BarService {

    private final BarRepository repo;

    private final UserService userService;

    public BarDto findById(UUID id) {
        Optional<Bar> opt = repo.findById(id);

        if(opt.isEmpty())
            throw new BarNotFoundException("El Bar solicitado no ha sido encontrado.");

        return BarDto.of(opt.get());
    }

    public Page<Bar> findAll(String search, Pageable pageable) {
        List<SearchCriteria> params = SearchCriteriaExtractor.extractSearchCriteriaList(search);

        GenericSpecificationBuilder<Bar> specificationBuilder = new GenericSpecificationBuilder<>(params, Bar.class);
        Specification<Bar> spec =  specificationBuilder.build();

        Page<Bar> bares = repo.findAll(spec, pageable);

        if(bares.isEmpty())
            throw new BarNotFoundException("No se encuentra ningún listado de bares.");

        return bares;

    }

    public Bar add(CreateBarDto dto, final User logged) {
        return repo.save(Bar.builder()
                        .name(dto.getName())
                        .description(dto.getDescription())
                        .direction(dto.getDirection())
                        .owner(logged)
                        .images(dto.getImages())
                        .build());
    }

    public Bar edit(UUID id, EditBarDto dto, final User logged) {
        return repo.findById(id)
                .map(b -> {
                    userService.checkOwner(b, logged.getId());
                    b.setName(dto.getName());
                    b.setDescription(dto.getDescription());
                    b.setDirection(dto.getDirection());
                    b.setImages(dto.getImages());
                    return repo.save(b);
                })
                .orElseThrow(() -> new BarNotFoundException("El Bar no existe"));
    }

    public void delete(UUID id, final User logged){
        if(repo.existsById(id)){
            repo.findById(id)
                    .map(bar -> {
                        userService.checkOwner(bar, logged.getId());
                        repo.delete(bar);
                        return "";
                    });
        }
    }


}
