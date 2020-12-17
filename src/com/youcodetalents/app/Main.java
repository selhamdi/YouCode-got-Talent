package com.youcodetalents.app;

import java.sql.SQLException;
import java.util.Scanner;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.youcodetalents.controllers.AdministratorController;
import com.youcodetalents.controllers.ParticipationController;
import com.youcodetalents.controllers.UserController;


public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		UserController user = new UserController();
		AdministratorController admin = new AdministratorController();
		ParticipationController participation = new ParticipationController();
		Scanner readerInt = new Scanner(System.in);
		Scanner readerString = new Scanner(System.in);
		Scanner readerChar = new Scanner(System.in);
		
		//phone number regex
		  String phoneRegex = "^(\\+212|0)([ \\-_/]*)(\\d[ \\-_/]*){9}$";
		//email regex
		  String emailRegex = "^(.+)@(.+)$";
		//check id   
		  String rgexNum = "^[0-9]{9}$";
		
		while(true) {
			
			System.out.println("1. S'inscrire autant que condidat");
			System.out.println("2. Se connecter autant qu'administrateur");
			int Choix= readerInt.nextInt();
			switch(Choix) {
			case 1:
				
				while(true) {
					System.out.println("Enter your first name, last name, email, numero tel:");
					  String fname = readerString.nextLine();
					  String lname = readerString.nextLine();
					  String email = readerString.nextLine();
					  String phone = readerString.nextLine();
					  if(email.matches(emailRegex) && phone.matches(phoneRegex)) {
						  user.addUser(fname, lname, email, phone);
						  System.out.println("Do you want to update infos? (y/n) : ");
						  char yesno = readerChar.next().charAt(0);
						  switch(yesno) {
						  case 'y':
							  while(yesno=='y') {
							  System.out.println("Enter new first name, last name, email, numero tel:");
							  fname = readerString.nextLine();
							  lname = readerString.nextLine();
							  email = readerString.nextLine();
							  phone = readerString.nextLine();
							  user.updateUser(fname, lname, email, phone, user.Id);
							  System.out.println("Do you want to update infos again? (y/n) : ");
							  yesno = readerChar.next().charAt(0);
							  }
							  break;
						  case 'n':
							  break;
						  }
						  participation.addParticipation(user.Id);
						  break;
					  }else {
						  System.out.println("Email or phone not valid! Enter valid infos.");
					  }
				}
				  
				  
				
				break;
			case 2:
				boolean loop = true;
				String adminEmail = "ahmed.mahmoud.admin@gmail.com";
	        	String adminPswrd = "123123";
	        	
	        	System.out.println("Enter your email :");
	        	String email = readerString.nextLine();
	        	System.out.println("Enter your  password :");
	        	String pswrd = readerString.nextLine();
	        	
	        	if(email.equals(adminEmail) && pswrd.equals(adminPswrd) ) {
	        		admin.adminConnected();
	        		while(loop) {
	    				System.out.println("1. Show all users");
	    				System.out.println("2. Show all paticipations");
	    				System.out.println("3. Show participation by email");
	    				System.out.println("4. Validate participation");
	    				System.out.println("5. Exit");
	    				int Choix2= readerInt.nextInt();
	    				switch(Choix2) {
	    				case 1:
	    					admin.getUsers();
	    					break;
	    				case 2:
	    					admin.showParticipations();
	    					break;
	    				case 3:
	    					System.out.println("Enter the user's email : ");
	    					String emailsearch = readerString.nextLine();
	    					System.out.println(admin.getParticipationByEmail(emailsearch).toString());
	    					break;
	    				case 4:
	    					System.out.println("Enter the user id: ");
	    					int userId = readerInt.nextInt();
	    					System.out.println("Enter the id of the category choosen by the user: ");
	    					int catId = readerInt.nextInt();
	    					System.out.println("Accept or deny this user (a/d): ");
	    					char action = readerChar.next().charAt(0);
	    					break;
	    				case 5:
	    					loop = false;
	    					break;
	    				}
	        		}
	        	}else {
	        		System.out.println("Wrong email or password !"); 
	        	}
	        	
	        	
				break;
			}
			
		}
		
	}

}
