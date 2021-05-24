package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="candidate_users")
public class Candidate extends User {
	
	@NotBlank(message="İsim Alanı Boş olamaz")
	@Size(min = 3, message = "İsim alanında en az 3 karakter kullanmanız gerekiyor") 
	@Column(name="name")
	private String name;
	
	@NotBlank(message="Soyisim Alanı Boş olamaz")
	@Column(name="surname")
	private String surname;
	
	@NotBlank(message="TC Kimlik Numarası Alanı Boş Olamaz")
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@NotBlank(message="Doğum Yılı Alanı Boş Olamaz")
	@Column(name="birth_year")
	private String birth_year;

}
