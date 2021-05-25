package com.hrms.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.hrms.entities.concretes.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	boolean existsByMail(String mail);
	
}
