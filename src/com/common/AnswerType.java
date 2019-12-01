/**
 * 
 */
package com.common;

/**
 * Answer Types.
 * 
 * @author umadhg1
 *
 */
public enum AnswerType {

	YES_NO("yes_no"), SCALES("scales");

	private String type;

	AnswerType(String type) {
		this.type = type;
	}

	public String getString() {
		return type;
	}
}
