package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connect.Database;
import skysync.core.plane;

public class plane_controller {
	
	
public static void newPlane(Database database , Scanner s) throws SQLException {
		
		//All sysouts for tests bsss
		System.out.println("Enter Plane model: ");
		String model = s.next();
		System.out.println("Enter First class number: ");
		String Fclass = s.next();
		System.out.println("Enter Premium class number: ");
		String permium = s.next();
		System.out.println("Enter Economy number: ");
		String economy = s.next();
		
		
		
		plane pl = new plane();
		pl.setModel(model);
		pl.setFclass(Fclass);
		pl.setPremium(permium);
		pl.setEconomy(economy);
		
		
		ArrayList<plane> plane = database.getAllDataPl();
		database.addPlane(pl);
	}
	public static void getPlaneM(Database database, Scanner s) throws SQLException {
		
	    System.out.println("Enter Plane model:");
	    String model = s.next();
	    
	    // Retrieve the list of passenger objects
	    List<plane> planes = database.getPlaneM(model); 
	   
	    if (!planes.isEmpty()) {
	        System.out.println("Planes details:");
	        for (plane pl : planes) {
	            System.out.println("ID: " + pl.getId());
	            System.out.println("Plane Model: " + pl.getModel());
	            System.out.println("First class number: " + pl.getFclass());
	            System.out.println("Premium class number: " + pl.getPremium());
	            System.out.println("Eonomy class number: " + pl.getEconomy());
	            System.out.println("---------------------------");
	        }
	    } else {
	        System.out.println("No Planes found.");
	    }
	}
	
	public static void editPlane(Database database, Scanner s) throws SQLException {
	    System.out.println("Enter the Plane id (-1 to skip): ");
	    int id = s.nextInt();
	    
	    // Set id to null if -1 is entered
	    Integer searchId = (id == -1) ? null : id;
	    
	    // Fetch the passenger using either id or phone
	    plane plane = database.getPlane(searchId);
	    
	    if (plane != null) {
	        // Ask for new details with the option to keep the old ones
	        System.out.println("Enter Plane Model (-1 to keep the old value): ");
	        String model = s.next();
	        if (model.equals("-1")) {
	        	model = plane.getModel();
	        }

	        System.out.println("Enter First Class number (-1 to keep the old value): ");
	        String Fclass = s.next();
	        if (Fclass.equals("-1")) {
	        	Fclass = plane.getFclass();
	        }

	        System.out.println("Enter Premium class number (-1 to keep the old value): ");
	        String premium = s.next();
	        if (premium.equals("-1")) {
	        	premium = plane.getPremium();
	        }

	        System.out.println("Enter Economy number (-1 to keep the old value): ");
	        String economy = s.next();
	        if (economy.equals("-1")) {
	        	economy = plane.getEconomy();
	        }

	        plane.setModel(model);
	        plane.setFclass(Fclass);
	        plane.setPremium(premium);
	        plane.setEconomy(economy);
	        

	        database.editPlane(plane);
	    } else {
	        System.out.println("plane not found.");
	    }
	}

	 public static void getAllPlanes(Database database) throws SQLException {
	    	ArrayList<plane> plane = database.getAllDataPl();
	    	System.out.println("==================================");
	    	System.out.println("==================================");
	    	for(plane pl: plane) {
	    		System.out.println("ID: " + pl.getId());
	            System.out.println("Plane Model: " + pl.getModel());
	            System.out.println("First class number: " + pl.getFclass());
	            System.out.println("Premium class number: " + pl.getPremium());
	            System.out.println("Eonomy class number: " + pl.getEconomy());
	    	System.out.println("==================================");
	    	System.out.println("==================================");
	    		
	    	}
	    		
	    }
	 public static void deletePlane(Database database , Scanner s) throws SQLException {
			int id;
			System.out.println("Enter passenger id:");
			id = s.nextInt();
			
			database.deletePlane(id);
		}
}
