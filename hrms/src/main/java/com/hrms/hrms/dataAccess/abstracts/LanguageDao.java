package com.hrms.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
