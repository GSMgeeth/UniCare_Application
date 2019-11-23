/**
 * 
 */
package com.model_controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.model.Student;
import com.model.Survey;

/**
 * SurveyControllerInterface contains operations of a survey.
 * 
 * @author umadhg1
 *
 */
public interface SurveyControllerInterface extends Remote {

	/**
	 * @param survey
	 * @throws RemoteException
	 */
	public void saveSurvey(Survey survey) throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Survey> getOngoingSurveys() throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Survey> getSurveyTemplates() throws RemoteException;

	/**
	 * @param surveyName
	 * @return
	 * @throws RemoteException
	 */
	public Survey getSurveyByName(String surveyName) throws RemoteException;

	/**
	 * @param batch
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Survey> getSurveysByBatch(String batch) throws RemoteException;

	/**
	 * @param courseID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Survey> getSurveysByCourseID(String courseID) throws RemoteException;

	/**
	 * @param surveyID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> getPendingStudentsForSurvey(long surveyID) throws RemoteException;

}
