package com.hrms.hrms.entities.dtos;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingAddDto {

	@JsonIgnore
	private int id;
	private int employerId;
	private int jobPositionId;
	private int openPositionNumber;
	private int minSalary;
	private int maxSalary;
	private int cityId;
	private Date createdDate;
	private Date closedDate;
	private String description;
	
}
