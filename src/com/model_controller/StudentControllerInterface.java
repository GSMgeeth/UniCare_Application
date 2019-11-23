/**
 * 
 */
package com.model_controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import com.model.Student;

/**
 * StudentControllerInterface contains operations of student and extends Remote
 * interface to be qualified to register as a RMI service.
 * 
 * @author umadhg1
 *
 */
public interface StudentControllerInterface extends Remote {

	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws RemoteException
	 */
	public Student login(String username, String password) throws RemoteException;

	/**
	 * @param student
	 * @throws RemoteException
	 */
	public void saveProfile(Student student) throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> getAllStudents() throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> getStudentsByName(String name) throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public Student getStudentByStudentID(long studentID) throws RemoteException;

	/**
	 * @return
	 * @throws RemoteException
	 */
	public Student getStudentByEmail(String email) throws RemoteException;

	/**
	 * @param batch
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> getStudentsByBatch(String batch) throws RemoteException;

	/**
	 * @param courseID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<Student> getStudentsByCourse(String courseID) throws RemoteException;
}
