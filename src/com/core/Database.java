/**
 * 
 */
package com.core;

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
	 * @throws UserInvalidException
	 */
	public static void saveInstructor(Instructor instructor) throws UserInvalidException {
		if (Validation.validateInstructorObject(instructor)) {
			// TBI
			logger.log(Level.INFO, "Instructor saved into database!");
		} else {
			throw new UserInvalidException();
		}
	}

	/**
	 * Save | update | soft delete the student in database.
	 * 
	 * @param student
	 * @throws UserInvalidException
	 */
	public static void saveStudent(Student student) throws UserInvalidException {
		if (Validation.validateStudentObject(student)) {
			// TBI
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
}
