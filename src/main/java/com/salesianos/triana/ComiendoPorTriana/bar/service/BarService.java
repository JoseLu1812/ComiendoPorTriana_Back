package com.salesianos.triana.ComiendoPorTriana.bar.service;

import com.salesianos.triana.ComiendoPorTriana.bar.model.Bar;
import com.salesianos.triana.ComiendoPorTriana.bar.repo.BarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarService {

    private final BarRepository repo;

}
