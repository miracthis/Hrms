package com.hrms.hrms.entities.concretes;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="verify_code")
@Inheritance(strategy = InheritanceType.JOINED)
public class VerifyCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="verify_code")
	private String verifyCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="confirmed_date")
	private Date confirmedDate;


	
	
}
