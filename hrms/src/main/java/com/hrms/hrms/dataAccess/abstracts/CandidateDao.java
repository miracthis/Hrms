package com.hrms.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Integer>{
		
	boolean existsByNationalIdentity(String national_identity);
	
		
}
