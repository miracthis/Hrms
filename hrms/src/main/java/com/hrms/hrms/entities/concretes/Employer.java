package com.hrms.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employer_users")
@PrimaryKeyJoinColumn(name="user_id")
public class Employer extends User{
	
	@NotBlank(message="Şirket İsmi Alanı Boş Olamaz")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message="Web Sitesi Alanı Boş Olamaz")
	@Column(name="web_address")
	private String webAddress;
	
	@NotBlank(message="Telefon Numarası Alanı Boş Olamaz")
	@Column(name="phone_number")
	private String phoneNumber;
	
	
}
