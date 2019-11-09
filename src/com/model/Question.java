/**
 * 
 */
package com.model;

import java.io.Serializable;

import com.common.AnswerType;

/**
 * Question class defines properties of a survey question.
 * 
 * @author umadhg1
 *
 */
public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long surveyID;
	private int questionID;
	private String QuestionText;
	private AnswerType answerType;
	private Answer[] answers;

	/**
	 * Default Constructor.
	 */
	public Question() {
		super();
	}

	/**
	 * Constructor with survey ID and question ID.
	 * 
	 * @param surveyID
	 * @param questionID
	 */
	public Question(long surveyID, int questionID) {
		super();
		this.surveyID = surveyID;
		this.questionID = questionID;
	}

	/**
	 * Constructor with question text, answer type (Enum), answers.
	 * 
	 * @param questionText
	 * @param answerType
	 * @param answers
	 */
	public Question(String questionText, AnswerType answerType, Answer[] answers) {
		super();
		QuestionText = questionText;
		this.answerType = answerType;
		this.answers = answers;
	}

	/**
	 * Constructor with all fields.
	 * 
	 * @param surveyID
	 * @param questionID
	 * @param questionText
	 * @param answerType
	 * @param answers
	 */
	public Question(long surveyID, int questionID, String questionText, AnswerType answerType, Answer[] answers) {
		super();
		this.surveyID = surveyID;
		this.questionID = questionID;
		QuestionText = questionText;
		this.answerType = answerType;
		this.answers = answers;
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
	 * @return the questionText
	 */
	public String getQuestionText() {
		return QuestionText;
	}

	/**
	 * @param questionText the questionText to set
	 */
	public void setQuestionText(String questionText) {
		QuestionText = questionText;
	}

	/**
	 * @return the answerType
	 */
	public AnswerType getAnswerType() {
		return answerType;
	}

	/**
	 * @param answerType the answerType to set
	 */
	public void setAnswerType(AnswerType answerType) {
		this.answerType = answerType;
	}

	/**
	 * @return the answers
	 */
	public Answer[] getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(Answer[] answers) {
		this.answers = answers;
	}

}
