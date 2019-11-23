/**
 * 
 */
package com.common;

import com.model.Instructor;
import com.model.Person;
import com.model.Student;
import com.model.Submission;
import com.model.Survey;

/**
 * Validation class consists of common validation operations.
 * 
 * @author umadhg1
 *
 */
public final class Validation {

	/**
	 * validates email address given.
	 * 
	 * @param email
	 * @return true if email is valid.
	 */
	public static boolean validateEmail(String email) {
		return true;
	}

	/**
	 * validates a person object.
	 * 
	 * @param person
	 * @return true if person is valid.
	 */
	private static boolean validatePersonObject(Person person) {
		if (person != null)
			if (person.getUsername() != null && person.getPassword() != null && !person.getUsername().equals("")
					&& !person.getPassword().equals(""))
				if (person.getPersonName() != null && !person.getPersonName().equals(""))
					if (person.getEmail() != null && !person.getEmail().equals("") && validateEmail(person.getEmail()))
						if (person.getSignedDate() != null)
							return true;

		return false;
	}

	/**
	 * validate instructor object.
	 * 
	 * @param instructor
	 * @return true if the instructor is valid.
	 */
	public static boolean validateInstructorObject(Instructor instructor) {
		if (validatePersonObject(instructor))
			return true;

		return false;
	}

	/**
	 * validate student object.
	 * 
	 * @param student
	 * @return true if the student is valid.
	 */
	public static boolean validateStudentObject(Student student) {
		if (validatePersonObject(student))
			if (student.getBatch() != null && !student.getBatch().equals(""))
				if (student.getCourseID() != null && !student.getCourseID().equals(""))
					return true;

		return false;
	}

	/**
	 * validates a survey object.
	 * 
	 * @param survey
	 * @return true if survey is valid.
	 */
	public static boolean validateSurveyObject(Survey survey) {
		if (survey != null)
			if (survey.getSurveyName() != null && !survey.getSurveyName().equals(""))
				if (survey.getQuestions() != null && !survey.getQuestions().isEmpty())
					if (survey.getQuestions().stream().filter(q -> (q.getAnswers() == null || q.getAnswers().isEmpty()))
							.count() == 0)
						if (survey.getBuiltDate() != null)
							if (survey.getCourseID() != null && !survey.getCourseID().equals(""))
								if (survey.getBuiltInstructorID() > 0)
									if (survey.getBatch() != null && !survey.getBatch().equals(""))
										return true;

		return false;
	}

	/**
	 * validates a submission object.
	 * 
	 * @param submission
	 * @return true if submission is valid.
	 */
	public static boolean validateSubmissionObject(Submission submission) {
		if (submission != null)
			if (submission.getSurveyID() > 0)
				if (submission.getSubmittedStudentID() > 0)
					if (submission.getQuestionsWithSubmittedAnswer() != null
							&& !submission.getQuestionsWithSubmittedAnswer().isEmpty()
							&& submission.getQuestionsWithSubmittedAnswer().stream()
									.filter(q -> (q.getAnswers() == null || q.getAnswers().isEmpty())).count() == 0)
						return true;

		return false;
	}
}
