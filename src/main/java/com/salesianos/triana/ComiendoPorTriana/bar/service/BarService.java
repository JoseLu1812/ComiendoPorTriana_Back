package com.salesianos.triana.ComiendoPorTriana.bar.service;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.BarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.CreateBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.EditBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.repo.BarRepository;
import com.salesianos.triana.ComiendoPorTriana.exception.BarNotFoundException;
import com.salesianos.triana.ComiendoPorTriana.files.service.StorageService;
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
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BarService {

    private final BarRepository repo;

    private final UserService userService;

    private final StorageService storageService;

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
    @Transactional
    public Bar add(CreateBarDto dto, final User logged, MultipartFile file) {
        String filename = storageService.store(file);
        String image = filename;

        Bar result = Bar.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .direction(dto.getDirection())
                .owner(logged)
                .image(image)
                .build();

        return repo.save(result);
    }

    public Bar edit(UUID id, EditBarDto dto, final User logged, MultipartFile file) {
        String filename = storageService.store(file);
        String image = filename;


        return repo.findById(id)
                .map(b -> {
                    //userService.checkOwner(b, logged.getId());
                    b.setName(dto.getName());
                    b.setDescription(dto.getDescription());
                    b.setDirection(dto.getDirection());
                    b.setImage(image);
                    return repo.save(b);
                })
                .orElseThrow(() -> new BarNotFoundException("El Bar no existe"));
    }

    public void delete(UUID id, final User logged){
        if(repo.existsById(id)){
            repo.findById(id)
                    .map(bar -> {
                        repo.delete(bar);
                        return "";
                    });
        }
    }


}
