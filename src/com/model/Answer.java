/**
 * 
 */
package com.model;

import java.io.Serializable;

/**
 * Answer class defines properties of an answer for a question in survey.
 * 
 * @author umadhg1
 *
 */
public class Answer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long surveyID;
	private int questionID;
	private int answerID;
	private String answerText;
	private boolean isCorrect;

	/**
	 * Default Constructor.
	 */
	public Answer() {
		super();
	}

	/**
	 * Constructor with survey ID, question ID and answer ID.
	 * 
	 * @param surveyID
	 * @param questionID
	 * @param answerID
	 */
	public Answer(long surveyID, int questionID, int answerID) {
		super();
		this.surveyID = surveyID;
		this.questionID = questionID;
		this.answerID = answerID;
	}

	/**
	 * Constructor with answer text and correctness in boolean.
	 * 
	 * @param answerText
	 * @param isCorrect
	 */
	public Answer(String answerText, boolean isCorrect) {
		super();
		this.answerText = answerText;
		this.isCorrect = isCorrect;
	}

	/**
	 * Constructor with all fields.
	 * 
	 * @param surveyID
	 * @param questionID
	 * @param answerID
	 * @param answerText
	 * @param isCorrect
	 */
	public Answer(long surveyID, int questionID, int answerID, String answerText, boolean isCorrect) {
		super();
		this.surveyID = surveyID;
		this.questionID = questionID;
		this.answerID = answerID;
		this.answerText = answerText;
		this.isCorrect = isCorrect;
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
	 * @return the questionID
	 */
	public int getQuestionID() {
		return questionID;
	}

	/**
	 * @param questionID the questionID to set
	 */
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	/**
	 * @return the answerID
	 */
	public int getAnswerID() {
		return answerID;
	}

	/**
	 * @param answerID the answerID to set
	 */
	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	/**
	 * @return the answerText
	 */
	public String getAnswerText() {
		return answerText;
	}

	/**
	 * @param answerText the answerText to set
	 */
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	/**
	 * @return the isCorrect
	 */
	public boolean isCorrect() {
		return isCorrect;
	}

	/**
	 * @param isCorrect the isCorrect to set
	 */
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

}
