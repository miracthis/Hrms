package com.hrms.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.hrms.entities.concretes.Candidates;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatesDao extends JpaRepository<Candidates, Integer>{
	
	boolean existsByMail(String mail);
	boolean existsByNationalIdentity(String national_identity);
		
}
