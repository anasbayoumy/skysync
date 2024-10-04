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
	public static void getPassengerN(Database database, Scanner s) throws SQLException {
	    // Get the first and last names from the user
	    System.out.println("Enter the first name:");
	    String Fname = s.next();
	    
	    System.out.println("Enter the last name:");
	    String Lname = s.next();
	    
	    // Retrieve the passenger object
	    passenger p = database.getPassengerN(Fname, Lname); // declare passenger variable

	    // Check if the passenger exists, then print details
	    if (p != null) {
	        System.out.println("Passenger details:");
	        System.out.println("ID: " + p.getId());
	        System.out.println("Full Name: " + p.getFname() + " " + p.getLname());
	        System.out.println("Email: " + p.getEmail());
	        System.out.println("Phone: " + p.getPhone());
	    } else {
	        System.out.println("Passenger not found.");
	    }
	}

	 public static void editPassenger(Database database , Scanner s) throws SQLException {
	    	System.out.println("Enter the passenger id or phone number \n -1 to show all passengers");
	    	int id = s.nextInt();
	    	String phone = s.next();
	    	if(id == -1) {
	    		getAllPassengers(database);
	    		System.out.println("If you find your id ,Please enter ur id:");
	    		id = s.nextInt();
	    		
	    	}
	    	passenger passenger = database.getPassenger(id, phone);
	    	System.out.println("Enter first name: \n -1 to save old value");
	    	String Fname = s.next();
	    	//if(String Fname = "-1") {
	    	if(Fname.equals("-1")) {
	    		Fname = passenger.getFname();
	    	}
	    	System.out.println("Enter Last name: \n -1 to save old value");
	    	String Lname = s.next();
	    	//if(String Fname = "-1") {
	    	if(Lname.equals("-1")) {
	    		Lname = passenger.getLname();
	    	}
	    	System.out.println("Enter email: \n -1 to save old value");
	    	String email = s.next();
	    	//if(String Fname = "-1") {
	    	if(email.equals("-1")) {
	    		email = passenger.getEmail();
	    	}
	    	System.out.println("Enter phone number: \n -1 to save old value");
	    	String phoneN = s.next();
	    	//if(String Fname = "-1") {
	    	if(phoneN.equals("-1")) {
	    		phoneN = passenger.getPhone();
	    	}
	    	passenger.setFname(Fname);
	    	passenger.setLname(Lname);
	    	passenger.setEmail(email);
	    	passenger.setPhone(phoneN);
	    	database.editPassenger(passenger);
	    	
	    }
	 public static void getAllPassengers(Database database) throws SQLException {
	    	ArrayList<passenger> passenger = database.getAllDataP();
	    	System.out.println("==================================");
	    	System.out.println("==================================");
	    	for(passenger p: passenger) {
	    		System.out.println("Id:" +p.getId());
	    		System.out.println("Full Name:" +p.getFname()+" " +p.getLname() );
	    		System.out.println("Email:" +p.getEmail());
	    		System.out.println("Phone number:" +p.getPhone());
	    	System.out.println("==================================");
	    	System.out.println("==================================");
	    		
	    	}
	    		
	    	
	    }
}
