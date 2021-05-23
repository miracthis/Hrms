package com.hrms.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.hrms.entities.concretes.JobPositions;

public interface JobPositionsDao extends JpaRepository<JobPositions,Integer> {

	boolean existsByPosition(String position);
		
}
