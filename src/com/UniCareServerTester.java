/**
 * 
 */
package com;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.common.Consts;
import com.model_controller.InstructorControllerInterface;
import com.model_controller.StudentControllerInterface;
import com.model_controller.SubmissionControllerInterface;
import com.model_controller.SurveyControllerInterface;

/**
 * UniCareServerTester class implements test cases for the UniCare server RMI
 * services.
 * 
 * @author umadhg1
 *
 */
public class UniCareServerTester {

	/**
	 * Logger for logging status reports.
	 */
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InstructorControllerInterface instructorController;
		StudentControllerInterface studentController;
		SurveyControllerInterface surveyController;
		SubmissionControllerInterface submissionController;

		try {
			Registry reg = LocateRegistry.getRegistry();

			instructorController = (InstructorControllerInterface) reg.lookup(Consts.INSTRUCTOR_SERVICE_HOSTNAME);

			logger.log(Level.INFO, "Bounded to the Instructor service!");

			instructorController.saveProfile(null);

		} catch (NotBoundException ex) {
			logger.log(Level.INFO, "Bounding to the Instructor service failed!");
			ex.printStackTrace();
		} catch (RemoteException ex) {
			logger.log(Level.INFO, "Registration Instructor service failed!");
			ex.printStackTrace();
		}

		try {
			Registry reg = LocateRegistry.getRegistry(1100);

			studentController = (StudentControllerInterface) reg.lookup(Consts.STUDENT_SERVICE_HOSTNAME);

			logger.log(Level.INFO, "Bounded to the Student service!");

			studentController.saveProfile(null);

		} catch (NotBoundException ex) {
			logger.log(Level.INFO, "Bounding to the Student service failed!");
			ex.printStackTrace();
		} catch (RemoteException ex) {
			logger.log(Level.INFO, "Registration Student service failed!");
			ex.printStackTrace();
		}

		try {
			Registry reg = LocateRegistry.getRegistry(1101);

			surveyController = (SurveyControllerInterface) reg.lookup(Consts.SURVEY_SERVICE_HOSTNAME);

			logger.log(Level.INFO, "Bounded to the Survey service!");

			logger.log(Level.INFO, surveyController.getSurveyByName("Survey Name").getSurveyName());

		} catch (NotBoundException ex) {
			logger.log(Level.INFO, "Bounding to the Survey service failed!");
			ex.printStackTrace();
		} catch (RemoteException ex) {
			logger.log(Level.INFO, "Registration Survey service failed!");
			ex.printStackTrace();
		}

		try {
			Registry reg = LocateRegistry.getRegistry(1102);

			submissionController = (SubmissionControllerInterface) reg.lookup(Consts.SUBMISSION_SERVICE_HOSTNAME);

			logger.log(Level.INFO, "Bounded to the Submission service!");

			logger.log(Level.INFO, submissionController.getSubmissionsForSurvey(10).get(0).getSurveyID() + "");

		} catch (NotBoundException ex) {
			logger.log(Level.INFO, "Bounding to the Submission service failed!");
			ex.printStackTrace();
		} catch (RemoteException ex) {
			logger.log(Level.INFO, "Registration Submission service failed!");
			ex.printStackTrace();
		}
	}

}
