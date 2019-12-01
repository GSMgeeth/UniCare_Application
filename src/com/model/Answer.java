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
	private long questionID;
	private long answerID;
	private String answerText;
	private boolean selected;

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
	public Answer(long surveyID, long questionID, long answerID) {
		super();
		this.surveyID = surveyID;
		this.questionID = questionID;
		this.answerID = answerID;
	}

	/**
	 * Constructor with answer text and correctness in boolean.
	 * 
	 * @param answerText
	 * @param selected
	 */
	public Answer(String answerText, boolean selected) {
		super();
		this.answerText = answerText;
		this.selected = selected;
	}

	/**
	 * Constructor with all fields.
	 * 
	 * @param surveyID
	 * @param questionID
	 * @param answerID
	 * @param answerText
	 * @param selected
	 */
	public Answer(long surveyID, long questionID, long answerID, String answerText, boolean selected) {
		super();
		this.surveyID = surveyID;
		this.questionID = questionID;
		this.answerID = answerID;
		this.answerText = answerText;
		this.selected = selected;
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
	public long getQuestionID() {
		return questionID;
	}

	/**
	 * @param questionID the questionID to set
	 */
	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}

	/**
	 * @return the answerID
	 */
	public long getAnswerID() {
		return answerID;
	}

	/**
	 * @param answerID the answerID to set
	 */
	public void setAnswerID(long answerID) {
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
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
