package com.hrms.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="confirm_employer_users")
public class ConfirmEmployer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@JsonIgnore
	private int Id;
	
	@OneToOne(targetEntity = Employer.class)
	@JoinColumn(name="employer_id", referencedColumnName="user_id")
	private Employer employer;
	
	@Column(name = "confirmed_staff_user")
	private int staffUser;
	
	@Column(name="confirmed_date")
	private Date confirmedDate;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
}
