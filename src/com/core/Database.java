/**
 * 
 */
package com.core;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.common.AnswerType;
import com.common.Consts;
import com.common.Validation;
import com.exception.SubmissionInvalidException;
import com.exception.SurveyInvalidException;
import com.exception.UserInvalidException;
import com.exception.UserTypeInvalidException;
import com.model.Answer;
import com.model.Instructor;
import com.model.Person;
import com.model.Question;
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
			String sql = "INSERT INTO instructor (name, email, signed_date, username, password, isDeleted) VALUES (?,?,?,?,?,?)";
			SqlConnection.updateDB(sql, ps -> {
				int i = 0;
				ps.setString(++i, instructor.getPersonName());
				ps.setString(++i, instructor.getEmail());
				ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(instructor.getSignedDate()));
				ps.setString(++i, instructor.getUsername());
				ps.setString(++i, instructor.getPassword());
				ps.setBoolean(++i, instructor.isDeleted());
				return ps;
			});

			logger.log(Level.INFO, "Instructor saved into database!");
		} else {
			logger.log(Level.SEVERE, "Instructor saving into database failed!");
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
			String sql = "INSERT INTO student (name, email, batch, course_id, signed_date, username, password, isDeleted) VALUES (?,?,?,?,?,?,?,?)";
			SqlConnection.updateDB(sql, ps -> {
				int i = 0;
				ps.setString(++i, student.getPersonName());
				ps.setString(++i, student.getEmail());
				ps.setString(++i, student.getBatch());
				ps.setString(++i, student.getCourseID());
				ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(student.getSignedDate()));
				ps.setString(++i, student.getUsername());
				ps.setString(++i, student.getPassword());
				ps.setBoolean(++i, student.isDeleted());
				return ps;
			});

			logger.log(Level.INFO, "Student saved into database!");
		} else {
			logger.log(Level.SEVERE, "Student saving into database failed!");
			throw new UserInvalidException();
		}
	}

	/**
	 * Save | update a survey in database.
	 * 
	 * @param survey
	 * @throws SurveyInvalidException
	 */
	public static void saveSurvey(Survey survey) throws Exception {
		if (Validation.validateSurveyObject(survey)) {
			String sql = "INSERT INTO survey (name, batch, course_id, built_date, published_date, ended_date, built_ins_id) VALUES (?,?,?,?,?,?,?)";
			SqlConnection.updateDB(sql, ps -> {
				int i = 0;
				ps.setString(++i, survey.getSurveyName());
				ps.setString(++i, survey.getBatch());
				ps.setString(++i, survey.getCourseID());
				ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(survey.getBuiltDate()));
				ps.setString(++i,
						survey.getPublishedDate() != null
								? new SimpleDateFormat("yyyy/MM/dd").format(survey.getPublishedDate())
								: null);
				ps.setString(++i,
						survey.getEndedDate() != null ? new SimpleDateFormat("yyyy/MM/dd").format(survey.getEndedDate())
								: null);
				ps.setLong(++i, survey.getBuiltInstructorID());
				return ps;
			});

			logger.log(Level.INFO, "Survey saved into database!");

			Calendar cal = Calendar.getInstance();

			cal.setTime(survey.getBuiltDate());
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int month = cal.get(Calendar.MONTH) + 1;
			int year = cal.get(Calendar.YEAR);

			ResultSet rs = SqlConnection.getData("Select MAX(id) from survey where built_ins_id="
					+ survey.getBuiltInstructorID() + " and built_date='" + year + "-" + month + "-" + day + "';");

			if (rs.first()) {
				long surveyId = rs.getLong(1);

				for (Question q : survey.getQuestions()) {

					ResultSet rsAnsType = SqlConnection
							.getData("Select id from answer_type where type='" + q.getAnswerType().getString() + "';");

					if (rsAnsType.first()) {
						long ansTypeId = rsAnsType.getLong(1);

						sql = "INSERT INTO question (survey_id, text, answer_type_id) VALUES (?,?,?)";
						SqlConnection.updateDB(sql, ps -> {
							int i = 0;
							ps.setLong(++i, surveyId);
							ps.setString(++i, q.getQuestionText());
							ps.setLong(++i, ansTypeId);
							return ps;
						});

						logger.log(Level.INFO, "Question: '" + q.getQuestionText() + "' saved into database!");

						ResultSet rsQues = SqlConnection
								.getData("Select MAX(id) from question where survey_id=" + surveyId + ";");

						if (rsQues.first()) {
							long quesId = rsQues.getLong(1);

							for (Answer ans : q.getAnswers()) {
								sql = "INSERT INTO answer (survey_id, question_id, text, selected) VALUES (?,?,?,?)";
								SqlConnection.updateDB(sql, ps -> {
									int i = 0;
									ps.setLong(++i, surveyId);
									ps.setLong(++i, quesId);
									ps.setString(++i, ans.getAnswerText());
									ps.setBoolean(++i, ans.isSelected());
									return ps;
								});

								logger.log(Level.INFO, "Question: '" + q.getQuestionText() + "' answer: '"
										+ ans.getAnswerText() + "' saved into database!");
							}
						}
					}
				}
			}
		} else {
			logger.log(Level.SEVERE, "Survey saving into database failed!");
			throw new SurveyInvalidException();
		}
	}

	/**
	 * Save | update a survey in database.
	 * 
	 * @param submission
	 * @throws SurveyInvalidException
	 */
	public static void saveSubmission(Submission submission) throws Exception {
		if (Validation.validateSubmissionObject(submission)) {

			ReentrantLock lock = new ReentrantLock();
			lock.lock();

			try {
				String sql = "INSERT INTO submission (survey_id, submitted_date) VALUES (?,?)";
				SqlConnection.updateDB(sql, ps -> {
					int i = 0;
					ps.setLong(++i, submission.getSurveyID());
					ps.setString(++i, new SimpleDateFormat("yyyy/MM/dd").format(submission.getSubmittedDate()));
					return ps;
				});

				logger.log(Level.INFO, "Submission saved into database!");

				Calendar cal = Calendar.getInstance();

				cal.setTime(submission.getSubmittedDate());
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int month = cal.get(Calendar.MONTH) + 1;
				int year = cal.get(Calendar.YEAR);

				ResultSet rs = SqlConnection.getData("Select MAX(id) from submission where survey_id="
						+ submission.getSurveyID() + " and submitted_date='" + year + "-" + month + "-" + day + "';");

				if (rs.first()) {
					long submissionId = rs.getLong(1);

					for (Question q : submission.getQuestionsWithSubmittedAnswer()) {

						sql = "INSERT INTO submitted_answer (survey_id, submission_id, question_id, answer_id) VALUES (?,?,?,?)";
						SqlConnection.updateDB(sql, ps -> {
							int i = 0;
							ps.setLong(++i, submission.getSurveyID());
							ps.setLong(++i, submissionId);
							ps.setLong(++i, q.getQuestionID());
							ps.setLong(++i, q.getAnswers().stream().filter(a -> a.isSelected()).findFirst().get()
									.getAnswerID());
							return ps;
						});

						logger.log(Level.INFO, "Submitted answer saved into database!");
					}
				}

			} finally {
				lock.unlock();
			}
		} else {
			logger.log(Level.SEVERE, "Submission saving into database failed!");
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
	public static Survey getSurveyByName(String surveyName) throws Exception {
		if (surveyName != null && !surveyName.equals("")) {
			Survey survey = new Survey();
			ArrayList<Question> questions = new ArrayList<Question>();

			ResultSet rs = SqlConnection.getData(
					"Select id, batch, course_id, built_date, published_date, ended_date from survey where name='"
							+ surveyName + "';");

			if (rs.first()) {
				long surveyId = rs.getLong(1);
				survey.setSurveyID(surveyId);
				survey.setSurveyName(surveyName);
				survey.setBatch(rs.getString(2));
				survey.setCourseID(rs.getString(3));
				survey.setBuiltDate(rs.getDate(4));
				survey.setPublishedDate(rs.getDate(5));
				survey.setEndedDate(rs.getDate(6));

				rs = SqlConnection
						.getData("Select id, text, answer_type_id from question where survey_id=" + surveyId + ";");

				while (rs.next()) {
					long questionId = rs.getLong(1);
					String qText = rs.getString(2);
					int ansTypeId = rs.getInt(3);

					Question question = new Question(surveyId, questionId);

					ResultSet rsAnsType = SqlConnection
							.getData("select type from answer_type where id=" + ansTypeId + ";");

					if (rsAnsType.first()) {
						String answerType = rsAnsType.getString(1);

						question.setQuestionText(qText);

						if (answerType.equalsIgnoreCase(AnswerType.SCALES.getString())) {
							question.setAnswerType(AnswerType.SCALES);
						} else if (answerType.equalsIgnoreCase(AnswerType.YES_NO.getString())) {
							question.setAnswerType(AnswerType.YES_NO);
						}

						ResultSet rsAns = SqlConnection.getData("select id, text from answer where survey_id="
								+ surveyId + " and question_id=" + questionId + ";");

						ArrayList<Answer> answers = new ArrayList<Answer>();

						while (rsAns.next()) {
							long answerId = rsAns.getLong(1);
							String ansText = rsAns.getString(2);

							answers.add(new Answer(surveyId, questionId, answerId, ansText, false));
						}

						question.setAnswers(answers);
					}

					questions.add(question);
				}

				survey.setQuestions(questions);
			}

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
