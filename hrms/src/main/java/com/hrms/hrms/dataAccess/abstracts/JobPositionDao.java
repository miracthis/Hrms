package com.hrms.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hrms.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {

	boolean existsByPosition(String position);
		
}
