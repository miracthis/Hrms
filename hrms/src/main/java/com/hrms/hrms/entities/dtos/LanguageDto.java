package com.hrms.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {
	
	@JsonIgnore
	private int id;
	private int resumeId;
	private String language;
	private char langLevel;
	

}
