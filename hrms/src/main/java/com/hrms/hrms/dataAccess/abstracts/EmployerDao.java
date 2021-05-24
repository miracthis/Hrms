package com.hrms.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
