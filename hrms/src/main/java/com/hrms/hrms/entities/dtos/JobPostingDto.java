package com.hrms.hrms.entities.dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {

	private String employerCompanyName;
	private String jobPositionPosition;
	private int openPositionNumber;
	private Date createdDate;
	private Date closedDate;
	private String description;
	
	
}
