/**
 * 
 */
package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Submission class defines properties of a submission by student for a survey.
 * 
 * @author umadhg1
 *
 */
public class Submission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long surveyID;
	private long submissionID;
	private Date submittedDate;
	private ArrayList<Question> questionsWithSubmittedAnswer;

	/**
	 * Default Constructor.
	 */
	public Submission() {
		super();
	}

	/**
	 * Constructor with survey ID, submission ID and submitted student ID.
	 * 
	 * @param surveyID
	 * @param submissionID
	 */
	public Submission(long surveyID, long submissionID) {
		super();
		this.surveyID = surveyID;
		this.submissionID = submissionID;
	}

	/**
	 * Constructor with submitted questions with submitted answers.
	 * 
	 * @param questionsWithSubmittedAnswer
	 */
	public Submission(ArrayList<Question> questionsWithSubmittedAnswer) {
		super();
		this.questionsWithSubmittedAnswer = questionsWithSubmittedAnswer;
	}

	/**
	 * Constructor with all fields.
	 * 
	 * @param surveyID
	 * @param submissionID
	 * @param questionsWithSubmittedAnswer
	 */
	public Submission(long surveyID, long submissionID, ArrayList<Question> questionsWithSubmittedAnswer) {
		super();
		this.surveyID = surveyID;
		this.submissionID = submissionID;
		this.questionsWithSubmittedAnswer = questionsWithSubmittedAnswer;
	}

	/**
	 * @param surveyID
	 * @param submittedDate
	 * @param questionsWithSubmittedAnswer
	 */
	public Submission(long surveyID, Date submittedDate, ArrayList<Question> questionsWithSubmittedAnswer) {
		super();
		this.surveyID = surveyID;
		this.submittedDate = submittedDate;
		this.questionsWithSubmittedAnswer = questionsWithSubmittedAnswer;
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
	 * @return the submissionID
	 */
	public long getSubmissionID() {
		return submissionID;
	}

	/**
	 * @param submissionID the submissionID to set
	 */
	public void setSubmissionID(long submissionID) {
		this.submissionID = submissionID;
	}

	/**
	 * @return the submittedDate
	 */
	public Date getSubmittedDate() {
		return submittedDate;
	}

	/**
	 * @param submittedDate the submittedDate to set
	 */
	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	/**
	 * @return the questionsWithSubmittedAnswer
	 */
	public ArrayList<Question> getQuestionsWithSubmittedAnswer() {
		return questionsWithSubmittedAnswer;
	}

	/**
	 * @param questionsWithSubmittedAnswer the questionsWithSubmittedAnswer to set
	 */
	public void setQuestionsWithSubmittedAnswer(ArrayList<Question> questionsWithSubmittedAnswer) {
		this.questionsWithSubmittedAnswer = questionsWithSubmittedAnswer;
	}

}
