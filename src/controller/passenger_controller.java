package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connect.Database;
import connect.functions;
import skysync.core.passenger;

public class passenger_controller {
	
	public static void newPassenger(Database database , Scanner s) throws SQLException {
		
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
		
	    System.out.println("Enter the first name:");
	    String Fname = s.next();
	    
	    System.out.println("Enter the last name:");
	    String Lname = s.next();
	    
	    // Retrieve the list of passenger objects
	    List<passenger> passengers = database.getPassengerN(Fname, Lname); 
	   
	    if (!passengers.isEmpty()) {
	        System.out.println("Passenger details:");
	        for (passenger p : passengers) {
	            System.out.println("ID: " + p.getId());
	            System.out.println("Full Name: " + p.getFname() + " " + p.getLname());
	            System.out.println("Email: " + p.getEmail());
	            System.out.println("Phone: " + p.getPhone());
	            System.out.println("---------------------------");
	        }
	    } else {
	        System.out.println("No passengers found.");
	    }
	}
	
	public static void editPassenger(Database database, Scanner s) throws SQLException {
	    System.out.println("Enter the passenger id (-1 to skip): ");
	    int id = s.nextInt();
	    
	    System.out.println("Enter the passenger phone number (-1 to skip): ");
	    String phone = s.next();
	    
	    // Set id to null if -1 is entered
	    Integer searchId = (id == -1) ? null : id;
	    String searchPhone = (phone.equals("-1")) ? null : phone;
	    
	    // Fetch the passenger using either id or phone
	    passenger passenger = database.getPassenger(searchId, searchPhone);
	    
	    if (passenger != null) {
	        // Ask for new details with the option to keep the old ones
	        System.out.println("Enter first name (-1 to keep the old value): ");
	        String Fname = s.next();
	        if (Fname.equals("-1")) {
	            Fname = passenger.getFname();
	        }

	        System.out.println("Enter last name (-1 to keep the old value): ");
	        String Lname = s.next();
	        if (Lname.equals("-1")) {
	            Lname = passenger.getLname();
	        }

	        System.out.println("Enter email (-1 to keep the old value): ");
	        String email = s.next();
	        if (email.equals("-1")) {
	            email = passenger.getEmail();
	        }

	        System.out.println("Enter phone number (-1 to keep the old value): ");
	        String phoneN = s.next();
	        if (phoneN.equals("-1")) {
	            phoneN = passenger.getPhone();
	        }

	        // Update the passenger object and save the changes
	        passenger.setFname(Fname);
	        passenger.setLname(Lname);
	        passenger.setEmail(email);
	        passenger.setPhone(phoneN);

	        database.editPassenger(passenger);
	    } else {
	        System.out.println("Passenger not found.");
	    }
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
	 public static void deletePassenger(Database database , Scanner s) throws SQLException {
			int id;
			System.out.println("Enter passenger id:");
			id = s.nextInt();
			
			database.deletePassenger(id);
		}
}
