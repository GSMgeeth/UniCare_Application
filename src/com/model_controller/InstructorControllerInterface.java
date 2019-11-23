/**
 * 
 */
package com.model_controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.model.Instructor;
import com.model.Student;
import com.model.Survey;

/**
 * InstructorControllerInterface contains operations of instructor and extends
 * Remote interface to be qualified to register as a RMI service.
 * 
 * @author umadhg1
 *
 */
public interface InstructorControllerInterface extends Remote {

	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public boolean login(String username, String password) throws RemoteException;

	/**
	 * @param instructor
	 * @throws RemoteException
	 */
	public void saveProfile(Instructor instructor) throws RemoteException;

	/**
	 * @param survey
	 * @throws RemoteException
	 */
	public void buildSurvey(Survey survey) throws RemoteException;

	/**
	 * @param surveyName
	 * @return
	 * @throws RemoteException
	 */
	public Survey loadSurveyByName(String surveyName) throws RemoteException;

	/**
	 * @param surveyID
	 * @throws RemoteException
	 */
	public void showSurveyAnalysis(long surveyID) throws RemoteException;

	/**
	 * Add Student to system.
	 * 
	 * @param student
	 * @throws RemoteException
	 */
	public void addStudent(Student student) throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> loadAllStudents() throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> loadStudentByName() throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public Student loadStudentByStudentID() throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public Student loadStudentByEmail() throws RemoteException;

	/**
	 * @param surveyID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> loadPendingStudentsForSurvey(long surveyID) throws RemoteException;

	/**
	 * @param batch
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> loadStudentsByBatch(String batch) throws RemoteException;

	/**
	 * @param courseID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> loadStudentsByCourse(String courseID) throws RemoteException;
}
