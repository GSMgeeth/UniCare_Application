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
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception in saving survey!");
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Survey> getOngoingSurveys() throws RemoteException {
		return Database.getOngoingSurveys();
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Survey> getSurveyTemplates() throws RemoteException {
		return Database.getSurveyTemplates();
	}

	/**
	 *
	 */
	@Override
	public Survey getSurveyByName(String surveyName) throws RemoteException {
		Survey survey = null;

		try {
			survey = Database.getSurveyByName(surveyName);
			logger.log(Level.INFO, "Survey fetched!");
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception in getting survey by name!");
			e.printStackTrace();
		}

		return survey;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Survey> getSurveysByBatch(String batch) throws RemoteException {
		return Database.getSurveysByBatch(batch);
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Survey> getSurveysByCourseID(String courseID) throws RemoteException {
		return Database.getSurveysByCourseID(courseID);
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getPendingStudentsForSurvey(long surveyID) throws RemoteException {
		return Database.getPendingStudentsForSurvey(surveyID);
	}

}
