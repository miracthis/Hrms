package com.hrms.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Email(message = "Lütfen Geçerli Bir Mail Adresi Giriniz")
	@NotBlank(message="Mail Alanı Boş olamaz")
	@Column(name="mail")
	private String mail;  
	
	@NotBlank(message="Şifre Alanı Boş olamaz")
	@Size(min=6, max=16, message="Şifre en az 6, en fazla 16 karakterden oluşabilir")
	@Column(name="password")
	private String password;
	
	@NotBlank(message="Şifre Alanı Boş olamaz")
	@Transient
	private String passwordRepeat;
	
	

}
