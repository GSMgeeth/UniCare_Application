/**
 * 
 */
package com.model_controller.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.Submission;
import com.model_controller.SubmissionControllerInterface;

/**
 * @author umadhg1
 *
 */
public class SubmissionControllerImpl extends UnicastRemoteObject implements SubmissionControllerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @throws RemoteException
	 */
	public SubmissionControllerImpl() throws RemoteException {
		super();
	}

	/**
	 *
	 */
	@Override
	public void saveSubmission(Submission submission) throws RemoteException {
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Submission Saved!");
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Submission> getSubmissionsForSurvey(long surveyID) throws RemoteException {

		ArrayList<Submission> submissions = new ArrayList<>();

		submissions.add(new Submission(surveyID, 1, 1, null));

		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Submissions under " + surveyID + " sent!");

		return submissions;
	}

}
