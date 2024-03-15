package com.roney.expensetracker.utilities;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class ToListMapper {

	private ModelMapper mapper;
	
	public ToListMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}
	
	public <E, D> List<D> mapList(List<E> sourceList, Class<D> destClass) {
        
		return sourceList.stream()
                .map(entity -> mapper.map(entity, destClass))
                .collect(Collectors.toList());
    }
	
}
