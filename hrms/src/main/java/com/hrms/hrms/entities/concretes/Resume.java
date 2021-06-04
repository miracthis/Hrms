package com.hrms.hrms.entities.concretes;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="resumes")

public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id", referencedColumnName =  "id" ,nullable = false)
	private Candidate candidate;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linked_link")
	private String linkedLink;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="updated_date")
	private Date updatedDate;
	
	@Column(name="is_active")
	private boolean isActive=true;
	
	
	 @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL ) 
	 private List<Language> languages;
	  
	 @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL ) 
	 private List<Technology> technologies;
	  
	 @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL ) 
	 private List<Education> education;
	 
	 @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL ) 
	 private List<JobExperience> jobExperiences;
	 
	
	

}
