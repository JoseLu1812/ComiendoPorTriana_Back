package com.salesianos.triana.ComiendoPorTriana.bar.service;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.BarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.CreateBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.model.dto.EditBarDto;
import com.salesianos.triana.ComiendoPorTriana.bar.repo.BarRepository;
import com.salesianos.triana.ComiendoPorTriana.exception.BarNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BarService {

    private final BarRepository repo;

    public BarDto findById(UUID id) {
        Optional<Bar> opt = repo.findById(id);

        if(opt.isEmpty())
            throw new BarNotFoundException("El Bar con ID %id no ha sido encontrado.");

        Bar result = opt.get();
        return BarDto.of(result);
    }

    public List<BarDto> findAll() {
        List<Bar> list = repo.findAll();

        if(list.isEmpty())
            throw new BarNotFoundException("No se encuentra ningún listado de bares.");

        List<BarDto> result = new ArrayList<BarDto>();

        for (Bar b:list) {
            result.add(BarDto.of(b));
        }

        return result;
    }

    public BarDto add(CreateBarDto dto) {
        Bar bar = repo.save(CreateBarDto.toBar(dto));

        return BarDto.of(bar);
    }

    public BarDto edit(UUID id, EditBarDto dto) {
        Optional<Bar> opt = repo.findById(id);

        if(opt.isEmpty())
            throw new BarNotFoundException("El Bar solicitado no existe");

        Bar bar = repo.save(EditBarDto.toBar(dto));

        return BarDto.of(bar);
    }


}
