/**
 * 
 */
package com.model_controller.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.common.Consts;
import com.core.Database;
import com.exception.UserInvalidException;
import com.exception.UserTypeInvalidException;
import com.model.Student;
import com.model_controller.StudentControllerInterface;

/**
 * @author umadhg1
 *
 */
public class StudentControllerImpl extends UnicastRemoteObject implements StudentControllerInterface {

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
	public StudentControllerImpl() throws RemoteException {
		super();
	}

	/**
	 *
	 */
	@Override
	public Student login(String username, String password) throws RemoteException {
		if (username == null | username.equals("") | password == null | password.equals("")) {
			logger.log(Level.WARNING, "Username\\password is null\\empty");
			return null;
		} else {
			try {
				Student student = (Student) Database.login(username, password, Consts.USER_TYPE_STUDENT);
				logger.log(Level.INFO, "Student successfully logged in!");
				return student;
			} catch (UserTypeInvalidException e) {
				logger.log(Level.WARNING, "User type is invalid!");
				e.printStackTrace();
				return null;
			}
		}
	}

	/**
	 *
	 */
	@Override
	public void saveProfile(Student student) throws RemoteException {
		try {
			Database.saveStudent(student);
			logger.log(Level.INFO, "Student saved!");
		} catch (UserInvalidException e) {
			logger.log(Level.WARNING, "User invalid!");
			e.printStackTrace();
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception in saving user!");
			e.printStackTrace();
		}
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getAllStudents() throws RemoteException {
		return Database.getAllStudents();
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getStudentsByName(String name) throws RemoteException {
		return Database.getStudentsByName(name);
	}

	/**
	 *
	 */
	@Override
	public Student getStudentByStudentID(long studentID) throws RemoteException {
		return Database.getStudentByStudentID(studentID);
	}

	/**
	 *
	 */
	@Override
	public Student getStudentByEmail(String email) throws RemoteException {
		return Database.getStudentByEmail(email);
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getStudentsByBatch(String batch) throws RemoteException {
		return Database.getStudentsByBatch(batch);
	}

	/**
	 *
	 */
	@Override
	public ArrayList<Student> getStudentsByCourse(String courseID) throws RemoteException {
		return Database.getStudentsByCourse(courseID);
	}

}
