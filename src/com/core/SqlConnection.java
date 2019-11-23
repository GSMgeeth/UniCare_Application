/**
 * 
 */
package com.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * SqlConnection class initiates SQL connection in localhost and do all the
 * transactions with the database.
 * 
 * @author umadhg1
 *
 */
public class SqlConnection {

	private static Connection conn = null;

	public static Connection getConnection() throws Exception {
		if (conn == null) {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/unicare?verifyServerCertificate=false&useSSL=true", "root", "");
		}

		return conn;
	}

	public static ResultSet getData(String qry) throws Exception {
		return SqlConnection.getConnection().prepareStatement(qry).executeQuery();
	}

	public static void updateDB(String q, Injectable inject) throws Exception {
		PreparedStatement ps = SqlConnection.getConnection().prepareStatement(q);
		ps = inject.inject(ps);
		ps.execute();
	}
}
