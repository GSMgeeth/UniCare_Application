/**
 * 
 */
package com.model_controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.model.Submission;

/**
 * SubmissionControllerInterface contains operations of a survey.
 * 
 * @author umadhg1
 *
 */
public interface SubmissionControllerInterface extends Remote {

	/**
	 * @param submission
	 * @throws RemoteException
	 */
	public void saveSubmission(Submission submission) throws RemoteException;

	/**
	 * @param surveyID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Submission> getSubmissionsForSurvey(long surveyID) throws RemoteException;
}
