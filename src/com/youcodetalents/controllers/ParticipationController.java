package com.youcodetalents.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Statement;
import java.util.regex.Pattern;

import java.util.Scanner;

import com.youcodetalents.config.Configuration;
import com.youcodetalents.controllers.UserController;

public class ParticipationController {
	
	Configuration configuration;
	Connection connection;
	Scanner scanner;
	
public ParticipationController() throws ClassNotFoundException, SQLException {
		
	configuration = new Configuration("jdbc:mysql://localhost:3306/youcodetalents", "root", "");
	connection = configuration.Connect();
	scanner = new Scanner(System.in);
	}
String timeRegex = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]";
		public void addParticipation(long Id) throws SQLException {
			
			System.out.println("Choose your category:");

    		String sqlString = "SELECT * FROM category";
    		PreparedStatement statement = connection.prepareStatement(sqlString);
    		ResultSet resultSet = statement.executeQuery();
    		
    		while(resultSet.next()) {
    			System.out.println(resultSet.getLong("id")+". "+resultSet.getString("name"));
    		}
    		
    		System.out.println("Choose category : ");
    		
    		String categoryStr = scanner.nextLine();
    		long category = Long.parseLong(categoryStr);
    		//Checking if id category exist
    		while(category > 6 || category < 1) {
    			System.out.println("category id not found , please select an available id in the list ");
    			categoryStr = scanner.nextLine();
        		category = Long.parseLong(categoryStr);
    		}
    		
    		System.out.println("Description :");
    		String desc = scanner.nextLine();
    		
    		System.out.println("Enter the start time of your show: (yyy-mmm-dd h:m:s)");
    		String startTime = scanner.nextLine();
    		Timestamp startTimestamp = null;
    		while(!startTime.matches(timeRegex)) {
    			System.out.println("unvalid format ,(yyy-mmm-dd h:m:s)");
    			System.out.println("Enter the start time of your show: (yyy-mmm-dd h:m:s)");
        		startTime = scanner.nextLine();
    			if(startTime.matches(timeRegex)) {
    				startTimestamp = Timestamp.valueOf(startTime);
    				break;
    			} 
    		}
    		
    		System.out.println("Enter the end time of your show: (yyy-mmm-dd h:m:s)");
    		String endTime = scanner.nextLine();
    		Timestamp endTimestamp = null;
    		while(!endTime.matches(timeRegex)) {
    			System.out.println("unvalid format ,(yyy-mmm-dd h:m:s)");
    			System.out.println("Enter the end time of your show: (yyy-mmm-dd h:m:s)");
    			endTime = scanner.nextLine();
    			if(endTime.matches(timeRegex)) {
    				endTimestamp =Timestamp.valueOf(endTime);
    				break;
    			}
    			 
    		}
    		
    		System.out.println("Enter the path of your attached file:");
    		String file = scanner.nextLine();
    		
    		boolean is_accepted = false;
    		
    		String query = "INSERT into participation (id_user ,id_category, description, show_start_time, show_end_time,attached_file,is_accepted) values(?,?,?,?,?,?,?)";
  		    PreparedStatement statement1 = connection.prepareStatement(query);
  			statement1.setLong(1, Id);
  			statement1.setLong(2, category);
  			statement1.setString(3, desc);
  			statement1.setTimestamp(4, startTimestamp);
  			statement1.setTimestamp(5, endTimestamp );
  			statement1.setString(6, file);
  			statement1.setBoolean(7, is_accepted );
  			
  			statement1.executeUpdate();
  		 
  		System.out.println("Stay up to date to see if u get accepted.");
		}




}
