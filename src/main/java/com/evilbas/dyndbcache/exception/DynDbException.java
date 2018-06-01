package com.evilbas.dyndbcache.exception;

/**
 * 
 * @author Evilbas
 *
 */

public class DynDbException extends Exception{

	private static final long serialVersionUID = 2033581991177335592L;
	
	public DynDbException(String errorMessage) {
		super(errorMessage);
	}
	
}
