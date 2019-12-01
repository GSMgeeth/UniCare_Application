/**
 * 
 */
package com.model_controller.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.common.Consts;
import com.core.Database;
import com.exception.UserInvalidException;
import com.exception.UserTypeInvalidException;
import com.model.Instructor;
import com.model_controller.InstructorControllerInterface;

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

	/**
	 * Logger for logging status reports.
	 */
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Constructor.
	 * 
	 * @throws RemoteException
	 */
	public InstructorControllerImpl() throws RemoteException {
		super();
	}

	/**
	 *
	 */
	@Override
	public Instructor login(String username, String password) throws RemoteException {
		if (username == null | username.equals("") | password == null | password.equals("")) {
			logger.log(Level.WARNING, "Username\\password is null\\empty");
			return null;
		} else {
			try {
				Instructor instructor = (Instructor) Database.login(username, password, Consts.USER_TYPE_INSTRUCTOR);
				logger.log(Level.INFO, "Instructor successfully logged in!");
				return instructor;
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
	public void saveProfile(Instructor instructor) throws RemoteException {
		try {
			Database.saveInstructor(instructor);
			logger.log(Level.INFO, "Instructor saved!");
		} catch (UserInvalidException e) {
			logger.log(Level.WARNING, "User invalid!");
			e.printStackTrace();
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception in saving user!");
			e.printStackTrace();
		}
	}
}
