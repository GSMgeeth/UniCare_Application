/**
 * 
 */
package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Person class defines common person properties for the application.
 * 
 * @author umadhg1
 *
 */
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long personID;
	private String personName;
	private Date signedDate;
	private String email;
	private String username;
	private String password;
	private boolean isDeleted;

	/**
	 * Default Constructor.
	 */
	public Person() {

	}

	/**
	 * Constructor with only person ID.
	 * 
	 * @param personID
	 */
	public Person(long personID) {
		super();
		this.personID = personID;
	}

	/**
	 * Constructor with username and password.
	 * 
	 * @param username
	 * @param password
	 */
	public Person(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Constructor with person name, signed date, email, username, password.
	 * 
	 * @param personName
	 * @param signedDate
	 * @param email
	 * @param username
	 * @param password
	 */
	public Person(String personName, Date signedDate, String email, String username, String password,
			boolean isDeleted) {
		this.personName = personName;
		this.signedDate = signedDate;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isDeleted = isDeleted;
	}

	/**
	 * Constructor with all fields.
	 * 
	 * @param personID
	 * @param personName
	 * @param signedDate
	 * @param email
	 * @param username
	 * @param password
	 */
	public Person(long personID, String personName, Date signedDate, String email, String username, String password,
			boolean isDeleted) {
		super();
		this.personID = personID;
		this.personName = personName;
		this.signedDate = signedDate;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the personID
	 */
	public long getPersonID() {
		return personID;
	}

	/**
	 * @param personID the personID to set
	 */
	public void setPersonID(long personID) {
		this.personID = personID;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @return the signedDate
	 */
	public Date getSignedDate() {
		return signedDate;
	}

	/**
	 * @param signedDate the signedDate to set
	 */
	public void setSignedDate(Date signedDate) {
		this.signedDate = signedDate;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the isDeleted
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
