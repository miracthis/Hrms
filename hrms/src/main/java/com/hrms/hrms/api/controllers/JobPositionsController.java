package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.JobPositionsService;
import com.hrms.hrms.entities.concretes.JobPositions;


@RestController
@RequestMapping("/api/jobs")
public class JobPositionsController {
	
	
	private JobPositionsService jobPositionsService;
	
	
	@Autowired
	public JobPositionsController(JobPositionsService jobPositionsService) {
		super();
		this.jobPositionsService = jobPositionsService;
	}



	@GetMapping("/getall")
	public List<JobPositions> getAll(){
		return this.jobPositionsService.getAll();
	}
	
	
	@PostMapping("/add")
	public JobPositions newJobPositions(@RequestBody JobPositions newJobPositions) {
		return this.jobPositionsService.newJobPositions(newJobPositions);
	  }
	
	@GetMapping("/get/{id}")
	public JobPositions getOne(@PathVariable int id) {
		return this.jobPositionsService.getOne(id);
		
	}
	
	@PutMapping("/update/{id}")
	public JobPositions updateJobPositions(@RequestBody JobPositions updateJobPositions, @PathVariable int id) {
		
		return jobPositionsService.updateJobPositions(updateJobPositions);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteJobPositions(@PathVariable int id) {
		jobPositionsService.deleteJobPositions(id);
		return "DB'den Silindi";
			
	}
	
	

}
