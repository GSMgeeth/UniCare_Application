/**
 * 
 */
package com.model_controller.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.model.Student;
import com.model.Survey;
import com.model_controller.StudentControllerInterface;
import com.model_controller.SubmissionControllerInterface;

/**
 * @author umadhg1
 *
 */
public class StudentControllerImpl extends UnicastRemoteObject implements StudentControllerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SubmissionControllerInterface submissionController;

	/**
	 * @throws RemoteException
	 */
	public StudentControllerImpl() throws RemoteException {
		super();
		submissionController = new SubmissionControllerImpl();
	}

	/**
	 *
	 */
	@Override
	public boolean login(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 *
	 */
	@Override
	public void saveProfile(Student student) throws RemoteException {
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Student Saved!");
	}

	/**
	 *
	 */
	@Override
	public void submitSurveyAnswers(Survey survey) throws RemoteException {
		submissionController.saveSubmission(null);
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getAllStudents() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getStudentByName() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public Student getStudentByStudentID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public Student getStudentByEmail() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getStudentsByBatch(String batch) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getStudentsByCourse(String courseID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
