/**
 * 
 */
package com.core;

import java.sql.PreparedStatement;

/**
 * @author umadhg1
 *
 */
public interface Injectable {
	PreparedStatement inject(PreparedStatement ps) throws Exception;
}
