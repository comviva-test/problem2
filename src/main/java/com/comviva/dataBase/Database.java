package com.comviva.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comviva.configuration.MyConnection;

@Component
public final class Database {
	
	@Autowired
	private MyConnection myConnection;
	
	public Database() {
	}
	
	/*
	 * Creates tables if not exists
	 */
	public void initializedTables() {
		try {
			Connection connection = myConnection.getConnection();
			Statement statement;
			statement = connection.createStatement();
			String sqlCreateTableComviva = "CREATE TABLE IF NOT EXISTS comviva (\n" + 
					" FILENAME VARCHAR(256) NOT NULL,\n" + 
					" FILEVALUE FLOAT,\n" + 
					" PROCESSDATE TIMESTAMP,\n" + 
					" PRIMARY KEY(FILENAME)\n" + 
					");";
			statement.execute(sqlCreateTableComviva);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save(String path, Double sum, Date date) {
		try {
			Connection connection = myConnection.getConnection();
			String sqlInsertRegister = "INSERT INTO comviva (FILENAME, FILEVALUE, PROCESSDATE)\n" + 
					"VALUES (?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sqlInsertRegister);
			ps.setString(1, path);
			ps.setDouble(2, sum);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(3, sqlDate);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
