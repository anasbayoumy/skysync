package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import connect.Database;
import connect.functions;
import skysync.core.passenger;

public class passenger_controller {
	public static void newPassenger(Database database , Scanner s) throws SQLException {
		int id;
		
		//All sysouts for tests bsss
		System.out.println("Enter first name: ");
		String Fname = s.next();
		System.out.println("Enter last name: ");
		String Lname = s.next();
		System.out.println("Enter your email address: ");
		String email = s.next();
		System.out.println("Enter your phone number: ");
		String phone = s.next();
		
		
		passenger p = new passenger();
		p.setFname(Fname);
		p.setLname(Lname);
		p.setEmail(email);
		p.setPhone(phone);
		
		ArrayList<passenger> passenger = database.getAllDataP();
		database.addPassenger(p);
	}

}
