package com.comviva;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.comviva.dataBase.Database;
import com.comviva.exception.FileProcessException;
import com.comviva.file.FileProcess;

@SpringBootApplication
public class App {
	
	private static Database db;
	
	@Autowired
	private Database dbAutowired;
	 
	@PostConstruct
	private void init() {
		db = this.dbAutowired;
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		db.initializedTables();
		FileProcess fp = new FileProcess();
		Double sum = null;
		String path = "/home/hernan/workspace/eclipse-workspace/comviva2/files/test1.txt";
		try {
			sum = fp.sumAllNumbers(path);
			System.out.println("The sum of all numbers are : " + sum);
		} catch (FileProcessException e) {
			e.printStackTrace();
		}
		db.save(path, sum, new Date());
	}

}
