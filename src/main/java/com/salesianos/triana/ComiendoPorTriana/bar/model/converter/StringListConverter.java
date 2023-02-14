package com.salesianos.triana.ComiendoPorTriana.bar.model.converter;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringListConverter implements AttributeConverter<List<String>, String> {

    @Override
    public String convertToDatabaseColumn(List<String> lista) {
        String strings = lista.stream().collect(Collectors.joining(","));
        return strings ;
    }

    @Override
    public List<String> convertToEntityAttribute(String s) {
        return new ArrayList<>(Arrays.asList(s.split(",")));
    }

}
