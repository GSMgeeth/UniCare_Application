/**
 * 
 */
package com.model_controller.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.model.Instructor;
import com.model.Student;
import com.model.Survey;
import com.model_controller.InstructorControllerInterface;
import com.model_controller.StudentControllerInterface;
import com.model_controller.SurveyControllerInterface;

/**
 * InstructorControllerImpl implements InstructorControllerInterface.
 * 
 * @author umadhg1
 *
 */
public class InstructorControllerImpl extends UnicastRemoteObject implements InstructorControllerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StudentControllerInterface studentController;
	private SurveyControllerInterface surveyController;

	/**
	 * Constructor.
	 * 
	 * @throws RemoteException
	 */
	public InstructorControllerImpl() throws RemoteException {
		super();
		studentController = new StudentControllerImpl();
		surveyController = new SurveyControllerImpl();
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
	public void saveProfile(Instructor instructor) throws RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	@Override
	public void buildSurvey(Survey survey) throws RemoteException {
		// TODO Auto-generated method stub

	}

	/**
	 *
	 */
	@Override
	public Survey loadSurveyByName(String surveyName) throws RemoteException {
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

	/**
	 * Implements InstructorOperation method from InstructorControllerInterface.
	 * 
	 * @throws RemoteException
	 */
	@Override
	public void addStudent(Student student) throws RemoteException {

		studentController.saveProfile(null);
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> loadAllStudents() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> loadStudentByName() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public Student loadStudentByStudentID() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public Student loadStudentByEmail() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> loadPendingStudentsForSurvey(long surveyID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> loadStudentsByBatch(String batch) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> loadStudentsByCourse(String courseID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
