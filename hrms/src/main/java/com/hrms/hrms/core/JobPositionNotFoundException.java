package com.hrms.hrms.core;

public class JobPositionNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public JobPositionNotFoundException(int id) {
	    super("Could not find employee " + id);
	  }

}
