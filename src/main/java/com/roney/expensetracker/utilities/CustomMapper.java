package com.roney.expensetracker.utilities;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class provides Model Mappers to convert between entity and DTOs. Model Mapper dependency is used.
 */

@Configuration
public class CustomMapper {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	//for mapping entity list to dto list or vice versa
	@Bean
	public ToListMapper listDtoMapper(ModelMapper mapper) {
		
		return new ToListMapper(mapper);
	}

}
