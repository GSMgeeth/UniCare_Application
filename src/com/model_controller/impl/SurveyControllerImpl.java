/**
 * 
 */
package com.model_controller.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.core.Database;
import com.exception.SurveyInvalidException;
import com.model.Student;
import com.model.Survey;
import com.model_controller.SurveyControllerInterface;

/**
 * @author umadhg1
 *
 */
public class SurveyControllerImpl extends UnicastRemoteObject implements SurveyControllerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Logger for logging status reports.
	 */
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * @throws RemoteException
	 */
	public SurveyControllerImpl() throws RemoteException {
		super();
	}

	/**
	 *
	 */
	@Override
	public void saveSurvey(Survey survey) {
		try {
			Database.saveSurvey(survey);
			logger.log(Level.INFO, "Survey saved!");
		} catch (SurveyInvalidException e) {
			logger.log(Level.WARNING, "Survey invalid!");
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Survey> getOngoingSurveys() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Survey> getSurveyTemplates() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public Survey getSurveyByName(String surveyName) throws RemoteException {

		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Survey " + surveyName + " sent!");
		return new Survey(surveyName, null, null, 1, null, null, null, null, null);
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Survey> getSurveysByBatch(String batch) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Survey> getSurveysByCourseID(String courseID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getPendingStudentsForSurvey(long surveyID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public void showSurveyAnalysis(long surveyID) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
