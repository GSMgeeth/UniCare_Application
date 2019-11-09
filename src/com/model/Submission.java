/**
 * 
 */
package com.model;

import java.io.Serializable;

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
	private int submissionID;
	private long submittedStudentID;
	private Question[] questionsWithSubmittedAnswer;

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
	 * @param submittedStudentID
	 */
	public Submission(long surveyID, int submissionID, long submittedStudentID) {
		super();
		this.surveyID = surveyID;
		this.submissionID = submissionID;
		this.submittedStudentID = submittedStudentID;
	}

	/**
	 * Constructor with submitted questions with submitted answers.
	 * 
	 * @param questionsWithSubmittedAnswer
	 */
	public Submission(Question[] questionsWithSubmittedAnswer) {
		super();
		this.questionsWithSubmittedAnswer = questionsWithSubmittedAnswer;
	}

	/**
	 * Constructor with all fields.
	 * 
	 * @param surveyID
	 * @param submissionID
	 * @param submittedStudentID
	 * @param questionsWithSubmittedAnswer
	 */
	public Submission(long surveyID, int submissionID, long submittedStudentID,
			Question[] questionsWithSubmittedAnswer) {
		super();
		this.surveyID = surveyID;
		this.submissionID = submissionID;
		this.submittedStudentID = submittedStudentID;
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
	public int getSubmissionID() {
		return submissionID;
	}

	/**
	 * @param submissionID the submissionID to set
	 */
	public void setSubmissionID(int submissionID) {
		this.submissionID = submissionID;
	}

	/**
	 * @return the submittedStudentID
	 */
	public long getSubmittedStudentID() {
		return submittedStudentID;
	}

	/**
	 * @param submittedStudentID the submittedStudentID to set
	 */
	public void setSubmittedStudentID(long submittedStudentID) {
		this.submittedStudentID = submittedStudentID;
	}

	/**
	 * @return the questionsWithSubmittedAnswer
	 */
	public Question[] getQuestionsWithSubmittedAnswer() {
		return questionsWithSubmittedAnswer;
	}

	/**
	 * @param questionsWithSubmittedAnswer the questionsWithSubmittedAnswer to set
	 */
	public void setQuestionsWithSubmittedAnswer(Question[] questionsWithSubmittedAnswer) {
		this.questionsWithSubmittedAnswer = questionsWithSubmittedAnswer;
	}

}
