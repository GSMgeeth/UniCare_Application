/**
 * 
 */
package com;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.common.Consts;
import com.model_controller.impl.InstructorControllerImpl;
import com.model_controller.impl.StudentControllerImpl;
import com.model_controller.impl.SubmissionControllerImpl;
import com.model_controller.impl.SurveyControllerImpl;

/**
 * UniCareServer class starts the main server with RMI service deployed for the
 * client.
 * 
 * @author umadhg1
 *
 */
public class UniCareServer {

	/**
	 * Logger for logging status reports.
	 */
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		deployRmiService();
		logger.log(Level.INFO, "UniCare Server Started...");
	}

	/**
	 * Deploy RMI Service for the client to use.
	 */
	public static void deployRmiService() {

		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind(Consts.INSTRUCTOR_SERVICE_HOSTNAME, new InstructorControllerImpl());

			logger.log(Level.INFO, "Registered the Instructor service!");
		} catch (RemoteException ex) {
			logger.log(Level.SEVERE, "Registering Instructor service failed!");
			ex.printStackTrace();
		}

		try {
			Registry reg = LocateRegistry.createRegistry(1100);
			reg.rebind(Consts.STUDENT_SERVICE_HOSTNAME, new StudentControllerImpl());

			logger.log(Level.INFO, "Registered the Student service!");
		} catch (RemoteException ex) {
			logger.log(Level.SEVERE, "Registering Student service failed!");
			ex.printStackTrace();
		}

		try {
			Registry reg = LocateRegistry.createRegistry(1101);
			reg.rebind(Consts.SURVEY_SERVICE_HOSTNAME, new SurveyControllerImpl());

			logger.log(Level.INFO, "Registered the Survey service!");
		} catch (RemoteException ex) {
			logger.log(Level.SEVERE, "Registering Survey service failed!");
			ex.printStackTrace();
		}

		try {
			Registry reg = LocateRegistry.createRegistry(1102);
			reg.rebind(Consts.SUBMISSION_SERVICE_HOSTNAME, new SubmissionControllerImpl());

			logger.log(Level.INFO, "Registered the Submission service!");
		} catch (RemoteException ex) {
			logger.log(Level.SEVERE, "Registering Submission service failed!");
			ex.printStackTrace();
		}
	}
}
