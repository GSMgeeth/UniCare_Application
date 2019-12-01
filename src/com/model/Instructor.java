/**
 * 
 */
package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Instructor class defines properties specific to instructor inheriting person
 * class.
 * 
 * @author umadhg1
 *
 */
public class Instructor extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default Constructor.
	 */
	public Instructor() {

	}

	/**
	 * Instructor constructor.
	 * 
	 * @param personName
	 * @param signedDate
	 * @param email
	 * @param username
	 * @param password
	 * @param isDeleted
	 */
	public Instructor(String personName, Date signedDate, String email, String username, String password,
			boolean isDeleted) {
		super(personName, signedDate, email, username, password, isDeleted);
	}
}
