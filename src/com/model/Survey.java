/**
 * 
 */
package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Survey class defines survey properties.
 * 
 * @author umadhg1
 *
 */
public class Survey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long surveyID;
	private String surveyName;
	private String batch;
	private String courseID;
	private long builtInstructorID;
	private Date builtDate;
	private Date publishedDate;
	private Date endedDate;
	private ArrayList<Question> questions;
	private ArrayList<Submission> submissions;

	/**
	 * Default Constructor.
	 */
	public Survey() {
		super();
	}

	/**
	 * Constructor with only survey ID.
	 * 
	 * @param surveyID
	 */
	public Survey(long surveyID) {
		super();
		this.surveyID = surveyID;
	}

	/**
	 * Constructor only without survey ID.
	 * 
	 * @param surveyName
	 * @param batch
	 * @param courseID
	 * @param builtInstructorID
	 * @param builtDate
	 * @param publishedDate
	 * @param endedDate
	 * @param questions
	 * @param submissions
	 */
	public Survey(String surveyName, String batch, String courseID, long builtInstructorID, Date builtDate,
			Date publishedDate, Date endedDate, ArrayList<Question> questions, ArrayList<Submission> submissions) {
		super();
		this.surveyName = surveyName;
		this.batch = batch;
		this.courseID = courseID;
		this.builtInstructorID = builtInstructorID;
		this.builtDate = builtDate;
		this.publishedDate = publishedDate;
		this.endedDate = endedDate;
		this.questions = questions;
		this.submissions = submissions;
	}

	/**
	 * Constructor with all fields.
	 * 
	 * @param surveyID
	 * @param surveyName
	 * @param batch
	 * @param courseID
	 * @param builtInstructorID
	 * @param builtDate
	 * @param publishedDate
	 * @param endedDate
	 * @param questions
	 * @param submissions
	 */
	public Survey(long surveyID, String surveyName, String batch, String courseID, long builtInstructorID,
			Date builtDate, Date publishedDate, Date endedDate, ArrayList<Question> questions,
			ArrayList<Submission> submissions) {
		super();
		this.surveyID = surveyID;
		this.surveyName = surveyName;
		this.batch = batch;
		this.courseID = courseID;
		this.builtInstructorID = builtInstructorID;
		this.builtDate = builtDate;
		this.publishedDate = publishedDate;
		this.endedDate = endedDate;
		this.questions = questions;
		this.submissions = submissions;
	}

	/**
	 * @return the surveyID
	 */
	public long getSurveyID() {
		return surveyID;
	}

	/**
	 * @param surveyID the surveyID to set
	 */
	public void setSurveyID(long surveyID) {
		this.surveyID = surveyID;
	}

	/**
	 * @return the surveyName
	 */
	public String getSurveyName() {
		return surveyName;
	}

	/**
	 * @param surveyName the surveyName to set
	 */
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
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
	 * @return the builtInstructorID
	 */
	public long getBuiltInstructorID() {
		return builtInstructorID;
	}

	/**
	 * @param builtInstructorID the builtInstructorID to set
	 */
	public void setBuiltInstructorID(long builtInstructorID) {
		this.builtInstructorID = builtInstructorID;
	}

	/**
	 * @return the builtDate
	 */
	public Date getBuiltDate() {
		return builtDate;
	}

	/**
	 * @param builtDate the builtDate to set
	 */
	public void setBuiltDate(Date builtDate) {
		this.builtDate = builtDate;
	}

	/**
	 * @return the publishedDate
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}

	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	/**
	 * @return the endedDate
	 */
	public Date getEndedDate() {
		return endedDate;
	}

	/**
	 * @param endedDate the endedDate to set
	 */
	public void setEndedDate(Date endedDate) {
		this.endedDate = endedDate;
	}

	/**
	 * @return the questions
	 */
	public ArrayList<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	/**
	 * @return the submissions
	 */
	public ArrayList<Submission> getSubmissions() {
		return submissions;
	}

	/**
	 * @param submissions the submissions to set
	 */
	public void setSubmissions(ArrayList<Submission> submissions) {
		this.submissions = submissions;
	}

}
