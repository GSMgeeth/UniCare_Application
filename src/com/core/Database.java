/**
 * 
 */
package com.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.common.Consts;
import com.common.Validation;
import com.exception.SubmissionInvalidException;
import com.exception.SurveyInvalidException;
import com.exception.UserInvalidException;
import com.exception.UserTypeInvalidException;
import com.model.Instructor;
import com.model.Person;
import com.model.Student;
import com.model.Submission;
import com.model.Survey;

/**
 * Database class persist data in the mysql database and retrieve data from the
 * database via SqlConnection class.
 * 
 * @author umadhg1
 *
 */
public class Database {

	/**
	 * Logger for logging status reports.
	 */
	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	/**
	 * Check users credentials in the database and return true if exists and false
	 * if otherwise.
	 * 
	 * @param username
	 * @param password
	 * @param userType
	 * @return Instructor
	 * @throws UserTypeInvalidException
	 */
	public static Person login(String username, String password, String userType) throws UserTypeInvalidException {
		switch (userType) {
		case Consts.USER_TYPE_INSTRUCTOR:
			// TBI
			return new Instructor();
		case Consts.USER_TYPE_STUDENT:
			// TBI
			return new Student();
		default:
			throw new UserTypeInvalidException();
		}
	}

	/**
	 * Save | update | soft delete the instructor in database.
	 * 
	 * @param instructor
	 * @throws Exception
	 */
	public static void saveInstructor(Instructor instructor) throws Exception {
		if (Validation.validateInstructorObject(instructor)) {

			String sql = "INSERT INTO instructor (name, email, uname, pw, reg_date) VALUES (?,?,?,?,?)";
			SqlConnection.updateDB(sql, ps -> {
				int i = 0;
				ps.setString(++i, instructor.getPersonName());
				ps.setString(++i, instructor.getEmail());
				ps.setString(++i, instructor.getUsername());
				ps.setString(++i, instructor.getPassword());
				ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(instructor.getSignedDate()));
				return ps;
			});

			logger.log(Level.INFO, "Instructor saved into database!");
		} else {
			throw new UserInvalidException();
		}
	}

	/**
	 * Save | update | soft delete the student in database.
	 * 
	 * @param student
	 * @throws Exception
	 */
	public static void saveStudent(Student student) throws Exception {
		if (Validation.validateStudentObject(student)) {

			String sql = "INSERT INTO student (name, email, batch, courseID, uname, pw, reg_date) VALUES (?,?,?,?,?,?,?)";
			SqlConnection.updateDB(sql, ps -> {
				int i = 0;
				ps.setString(++i, student.getPersonName());
				ps.setString(++i, student.getEmail());
				ps.setString(++i, student.getBatch());
				ps.setString(++i, student.getCourseID());
				ps.setString(++i, student.getUsername());
				ps.setString(++i, student.getPassword());
				ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(student.getSignedDate()));
				return ps;
			});

			logger.log(Level.INFO, "Student saved into database!");
		} else {
			throw new UserInvalidException();
		}
	}

	/**
	 * Save | update a survey in database.
	 * 
	 * @param survey
	 * @throws SurveyInvalidException
	 */
	public static void saveSurvey(Survey survey) throws SurveyInvalidException {
		if (Validation.validateSurveyObject(survey)) {
			// TBI
			logger.log(Level.INFO, "Survey saved into database!");
		} else {
			throw new SurveyInvalidException();
		}
	}

	/**
	 * Save | update a survey in database.
	 * 
	 * @param submission
	 * @throws SurveyInvalidException
	 */
	public static void saveSubmission(Submission submission) throws SubmissionInvalidException {
		if (Validation.validateSubmissionObject(submission)) {
			// TBI
			logger.log(Level.INFO, "Submission saved into database!");
		} else {
			throw new SubmissionInvalidException();
		}
	}

	/**
	 * Get All Students from the database.
	 * 
	 * @return Student list.
	 */
	public static ArrayList<Student> getAllStudents() {
		ArrayList<Student> students = new ArrayList<Student>();
		// TBI

		return students;
	}

	/**
	 * Get Students by name.
	 * 
	 * @param name
	 * @return Student list.
	 */
	public static ArrayList<Student> getStudentsByName(String name) {
		if (name != null && !name.equals("")) {
			ArrayList<Student> students = new ArrayList<Student>();
			// TBI

			return students;
		}

		return null;
	}

	/**
	 * Get Student by ID.
	 * 
	 * @param studentID
	 * @return Student.
	 */
	public static Student getStudentByStudentID(long studentID) {
		if (studentID > 0) {
			Student student = new Student();
			// TBI

			return student;
		}

		return null;
	}

	/**
	 * Get Student by Email.
	 * 
	 * @param email
	 * @return Student.
	 */
	public static Student getStudentByEmail(String email) {
		if (email != null && !email.equals("")) {
			Student student = new Student();
			// TBI

			return student;
		}

		return null;
	}

	/**
	 * Get Students by batch.
	 * 
	 * @param batch
	 * @return Student list.
	 */
	public static ArrayList<Student> getStudentsByBatch(String batch) {
		if (batch != null && !batch.equals("")) {
			ArrayList<Student> students = new ArrayList<Student>();
			// TBI

			return students;
		}

		return null;
	}

	/**
	 * Get Students by course ID.
	 * 
	 * @param courseID
	 * @return Student list.
	 */
	public static ArrayList<Student> getStudentsByCourse(String courseID) {
		if (courseID != null && !courseID.equals("")) {
			ArrayList<Student> students = new ArrayList<Student>();
			// TBI

			return students;
		}

		return null;
	}

	/**
	 * Get ongoing surveys.
	 * 
	 * @return Survey list.
	 */
	public static ArrayList<Survey> getOngoingSurveys() {
		ArrayList<Survey> surveys = new ArrayList<Survey>();
		// TBI

		return surveys;
	}

	/**
	 * Get Survey templates.
	 * 
	 * @return Survey list with empty attribute values.
	 */
	public static ArrayList<Survey> getSurveyTemplates() {
		ArrayList<Survey> surveys = new ArrayList<Survey>();
		// TBI

		return surveys;
	}

	/**
	 * Get Survey By ID.
	 * 
	 * @param surveyID
	 * @return Survey.
	 */
	public static Survey getSurveyByID(long surveyID) {
		Survey survey = new Survey();
		// TBI

		return survey;
	}

	/**
	 * Get Survey by name.
	 * 
	 * @param surveyName
	 * @return Survey.
	 */
	public static Survey getSurveyByName(String surveyName) {
		if (surveyName != null && !surveyName.equals("")) {
			Survey survey = new Survey();
			// TBI

			return survey;
		}

		return null;
	}

	/**
	 * Get Survey by batch.
	 * 
	 * @param batch
	 * @return Survey list
	 */
	public static ArrayList<Survey> getSurveysByBatch(String batch) {
		if (batch != null && !batch.equals("")) {
			ArrayList<Survey> surveys = new ArrayList<Survey>();
			// TBI

			return surveys;
		}

		return null;
	}

	/**
	 * Get Survey by course ID
	 * 
	 * @param courseID
	 * @return Survey list.
	 */
	public static ArrayList<Survey> getSurveysByCourseID(String courseID) {
		if (courseID != null && !courseID.equals("")) {
			ArrayList<Survey> surveys = new ArrayList<Survey>();
			// TBI

			return surveys;
		}

		return null;
	}

	/**
	 * Get students who have not submitted for the survey.
	 * 
	 * @param surveyID
	 * @return Student list.
	 */
	public static ArrayList<Student> getPendingStudentsForSurvey(long surveyID) {
		if (surveyID > 0) {
			ArrayList<Student> students = new ArrayList<Student>();
			// TBI

			return students;
		}

		return null;
	}

	/**
	 * Get Submissions for a particular survey.
	 * 
	 * @param surveyID
	 * @return Submission list.
	 */
	public static ArrayList<Submission> getSubmissionsForSurvey(long surveyID) {
		if (surveyID > 0) {
			ArrayList<Submission> submissions = new ArrayList<Submission>();
			// TBI

			return submissions;
		}

		return null;
	}
}
