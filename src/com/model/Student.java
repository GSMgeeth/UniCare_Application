/**
 * 
 */
package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Student class defines properties specific to student inheriting person class.
 * 
 * @author umadhg1
 *
 */
public class Student extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String batch;
	private String courseID;
	private long addedInstructorID;

	/**
	 * Default Constructor.
	 */
	public Student() {
		super();
	}

	/**
	 * Constructor with batch ID and course ID.
	 * 
	 * @param batch
	 * @param courseID
	 */
	public Student(String batch, String courseID) {
		super();
		this.batch = batch;
		this.courseID = courseID;
	}

	/**
	 * Constructor with batch ID, course ID and added instructor ID.
	 * 
	 * @param batch
	 * @param courseID
	 * @param addedInstructorID
	 */
	public Student(String batch, String courseID, long addedInstructorID) {
		super();
		this.batch = batch;
		this.courseID = courseID;
		this.addedInstructorID = addedInstructorID;
	}

	/**
	 * Student constructor.
	 * 
	 * @param personName
	 * @param signedDate
	 * @param email
	 * @param username
	 * @param password
	 * @param isDeleted
	 */
	public Student(String personName, Date signedDate, String email, String username, String batch, String courseID,
			long addedInstructorID, String password, boolean isDeleted) {
		super(personName, signedDate, email, username, password, isDeleted);
		this.batch = batch;
		this.courseID = courseID;
		this.addedInstructorID = addedInstructorID;
	}

	/**
	 * @return the batch
	 */
	public String getBatch() {
		return batch;
	}

	/**
	 * @param batch the batch to set
	 */
	public void setBatch(String batch) {
		this.batch = batch;
	}

	/**
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}

	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	/**
	 * @return the addedInstructorID
	 */
	public long getAddedInstructorID() {
		return addedInstructorID;
	}

	/**
	 * @param addedInstructorID the addedInstructorID to set
	 */
	public void setAddedInstructorID(long addedInstructorID) {
		this.addedInstructorID = addedInstructorID;
	}

}
