/**
 * 
 */
package com.model_controller;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.model.Instructor;

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
	public Instructor login(String username, String password) throws RemoteException;

	/**
	 * @param instructor
	 * @throws RemoteException
	 */
	public void saveProfile(Instructor instructor) throws RemoteException;
}
