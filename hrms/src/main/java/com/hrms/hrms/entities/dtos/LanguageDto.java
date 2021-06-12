package com.hrms.hrms.entities.dtos;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {
	
	
	private int resumeId;
	private String language;
	private char langLevel;
	private Date createdDate;
	

}
