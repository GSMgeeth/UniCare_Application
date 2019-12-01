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
import com.model.Answer;
import com.model.Question;
import com.model.Survey;
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

//		InstructorControllerInterface instructorController;
//		StudentControllerInterface studentController;
		SurveyControllerInterface surveyController;
//		SubmissionControllerInterface submissionController;

//		try {
//			Registry reg = LocateRegistry.getRegistry();
//
//			instructorController = (InstructorControllerInterface) reg.lookup(Consts.INSTRUCTOR_SERVICE_HOSTNAME);
//
//			logger.log(Level.INFO, "Bounded to the Instructor service!");
//
//			Calendar cal = Calendar.getInstance();
//
//			instructorController
//					.saveProfile(new Instructor("ins 3", cal.getTime(), "ins3@gmail.com", "ins3un", "ins3pw", false));
//
//		} catch (NotBoundException ex) {
//			logger.log(Level.INFO, "Bounding to the Instructor service failed!");
//			ex.printStackTrace();
//		} catch (RemoteException ex) {
//			logger.log(Level.INFO, "Registration Instructor service failed!");
//			ex.printStackTrace();
//		}
//
//		try {
//			Registry reg = LocateRegistry.getRegistry(1100);
//
//			studentController = (StudentControllerInterface) reg.lookup(Consts.STUDENT_SERVICE_HOSTNAME);
//
//			logger.log(Level.INFO, "Bounded to the Student service!");
//
//			Calendar cal = Calendar.getInstance();
//
//			studentController.saveProfile(new Student("stu 4", cal.getTime(), "stu4@gmail.com", "stu4un", "2018",
//					"cs_001", 2, "stu4pw", false));
//
//		} catch (NotBoundException ex) {
//			logger.log(Level.INFO, "Bounding to the Student service failed!");
//			ex.printStackTrace();
//		} catch (RemoteException ex) {
//			logger.log(Level.INFO, "Registration Student service failed!");
//			ex.printStackTrace();
//		}

//		try {
//			Registry reg = LocateRegistry.getRegistry(1101);
//
//			surveyController = (SurveyControllerInterface) reg.lookup(Consts.SURVEY_SERVICE_HOSTNAME);
//
//			logger.log(Level.INFO, "Bounded to the Survey service!");
//
//			Calendar cal = Calendar.getInstance();
//
//			ArrayList<Question> questions = new ArrayList<Question>();
//			ArrayList<Answer> answersForQ1 = new ArrayList<Answer>();
//			ArrayList<Answer> answersForQ2 = new ArrayList<Answer>();
//
//			for (int i = 0; i < 5; i++) {
//				answersForQ1.add(new Answer("" + (i + 1), false));
//			}
//
//			answersForQ2.add(new Answer("yes", false));
//			answersForQ2.add(new Answer("no", false));
//
//			Question question1 = new Question("Question 1", AnswerType.SCALES, answersForQ1);
//			Question question2 = new Question("Question 2", AnswerType.YES_NO, answersForQ2);
//
//			questions.add(question1);
//			questions.add(question2);
//
//			surveyController.saveSurvey(
//					new Survey("survey 1", "2017", "cs_001", 1, cal.getTime(), cal.getTime(), null, questions, null));
//
//		} catch (NotBoundException ex) {
//			logger.log(Level.INFO, "Bounding to the Survey service failed!");
//			ex.printStackTrace();
//		} catch (RemoteException ex) {
//			logger.log(Level.INFO, "Registration Survey service failed!");
//			ex.printStackTrace();
//		}

//		try {
//			Registry reg = LocateRegistry.getRegistry(1102);
//
//			submissionController = (SubmissionControllerInterface) reg.lookup(Consts.SUBMISSION_SERVICE_HOSTNAME);
//
//			logger.log(Level.INFO, "Bounded to the Submission service!");
//
//			Calendar cal = Calendar.getInstance();
//
//			ArrayList<Question> questions = new ArrayList<Question>();
//			ArrayList<Answer> answersForQ1 = new ArrayList<Answer>();
//			ArrayList<Answer> answersForQ2 = new ArrayList<Answer>();
//
//			for (int i = 0; i < 5; i++) {
//				if (i == 2) {
//					answersForQ1.add(new Answer(14, 1, (i + 1), "" + (i + 1), true));
//					continue;
//				}
//
//				answersForQ1.add(new Answer(14, 1, (i + 1), "" + (i + 1), false));
//			}
//
//			answersForQ2.add(new Answer(14, 2, 6, "yes", false));
//			answersForQ2.add(new Answer(14, 2, 7, "no", true));
//
//			Question question1 = new Question(14, 1, "Question 1", AnswerType.SCALES, answersForQ1);
//			Question question2 = new Question(14, 2, "Question 2", AnswerType.YES_NO, answersForQ2);
//
//			questions.add(question1);
//			questions.add(question2);
//
//			Submission submission = new Submission(14, cal.getTime(), questions);
//
//			submissionController.saveSubmission(submission);
//
//		} catch (NotBoundException ex) {
//			logger.log(Level.INFO, "Bounding to the Submission service failed!");
//			ex.printStackTrace();
//		} catch (RemoteException ex) {
//			logger.log(Level.INFO, "Registration Submission service failed!");
//			ex.printStackTrace();
//		}

		try {
			Registry reg = LocateRegistry.getRegistry(1101);

			surveyController = (SurveyControllerInterface) reg.lookup(Consts.SURVEY_SERVICE_HOSTNAME);

			logger.log(Level.INFO, "Bounded to the Survey service!");

//			Calendar cal = Calendar.getInstance();

//			ArrayList<Question> questions = new ArrayList<Question>();
//			ArrayList<Answer> answersForQ1 = new ArrayList<Answer>();
//			ArrayList<Answer> answersForQ2 = new ArrayList<Answer>();
//
//			for (int i = 0; i < 5; i++) {
//				answersForQ1.add(new Answer("" + (i + 1), false));
//			}
//
//			answersForQ2.add(new Answer("yes", false));
//			answersForQ2.add(new Answer("no", false));
//
//			Question question1 = new Question("Q 1", AnswerType.SCALES, answersForQ1);
//			Question question2 = new Question("Q 2", AnswerType.YES_NO, answersForQ2);
//
//			questions.add(question1);
//			questions.add(question2);
//
//			surveyController.saveSurvey(
//					new Survey("survey 4", "2018", "cs_001", 2, cal.getTime(), cal.getTime(), null, questions, null));

			Survey survey = surveyController.getSurveyByName("survey 4");

			System.out.println("Survey Id : " + survey.getSurveyID());
			System.out.println("Survey Name : " + survey.getSurveyName());
			System.out.println("Batch : " + survey.getBatch());
			System.out.println("Course Id : " + survey.getCourseID());
			System.out.println("Built date : " + survey.getBuiltDate());
			System.out.println("Published date : " + survey.getPublishedDate());

			for (Question q : survey.getQuestions()) {
				System.out.println("Q Id : " + q.getQuestionID());
				System.out.println("Q Text : " + q.getQuestionText());
				System.out.println("Ans type : " + q.getAnswerType());

				for (Answer ans : q.getAnswers()) {
					System.out.println("Ans Id : " + ans.getAnswerID());
					System.out.println("Ans Text : " + ans.getAnswerText());
				}
			}

		} catch (NotBoundException ex) {
			logger.log(Level.INFO, "Bounding to the Survey service failed!");
			ex.printStackTrace();
		} catch (RemoteException ex) {
			logger.log(Level.INFO, "Registration Survey service failed!");
			ex.printStackTrace();
		}
	}

}
