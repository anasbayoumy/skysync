package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connect.Database;
import skysync.core.employee;
import skysync.core.passenger;

public class employee_controller {
	public static void newEmployee(Database database , Scanner s) throws SQLException {
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
		System.out.println("Enter job title: ");
		String title = s.next();
		System.out.println("Enter the amount of the salary: ");
		double salary = s.nextDouble();
		
		employee e = new employee();
		e.setFname(Fname);
		e.setLname(Lname);
		e.setEmail(email);
		e.setPhone(phone);
		e.setTitle(title);
		e.setSalary(salary);
		
		ArrayList<employee> employee = database.getAllDataE();
		database.addEmployee(e);
	}
	
	public static void editEmployee(Database database, Scanner s) throws SQLException {
	    System.out.println("Enter the employee id (-1 to skip): ");
	    int id = s.nextInt();
	    
	    System.out.println("Enter the employee phone number (-1 to skip): ");
	    String phone = s.next();
	    
	    // Set id to null if -1 is entered
	    Integer searchId = (id == -1) ? null : id;
	    String searchPhone = (phone.equals("-1")) ? null : phone;
	    
	    // Fetch the passenger using either id or phone
	    employee employee = database.getEmployee(searchId, searchPhone);
	    
	    if (employee != null) {
	        // Ask for new details with the option to keep the old ones
	        System.out.println("Enter first name (-1 to keep the old value): ");
	        String Fname = s.next();
	        if (Fname.equals("-1")) {
	            Fname = employee.getFname();
	        }

	        System.out.println("Enter last name (-1 to keep the old value): ");
	        String Lname = s.next();
	        if (Lname.equals("-1")) {
	            Lname = employee.getLname();
	        }

	        System.out.println("Enter email (-1 to keep the old value): ");
	        String email = s.next();
	        if (email.equals("-1")) {
	            email = employee.getEmail();
	        }

	        System.out.println("Enter phone number (-1 to keep the old value): ");
	        String phoneN = s.next();
	        if (phoneN.equals("-1")) {
	            phoneN = employee.getPhone();
	        }
	        System.out.println("Enter job title (-1 to keep the old value)");
	        String title = s.next();
	        if(title.equals("-1")) {
	        	title =employee.getTitle();
	        }
	        System.out.println("Enter salary amount (-1 to keep the old value)");
	        double salary = s.nextDouble();
	        if(salary == -1) {
	        	salary = employee.getSalary();
	        }

	        // Update the passenger object and save the changes
	        employee.setFname(Fname);
	        employee.setLname(Lname);
	        employee.setEmail(email);
	        employee.setPhone(phoneN);
	        employee.setTitle(title);
	        employee.setSalary(salary);

	        database.editEmployee(employee);
	    } else {
	        System.out.println("Employee not found.");
	    }
	}
public static void getEmployeeN(Database database, Scanner s) throws SQLException {
		
	    System.out.println("Enter the first name:");
	    String Fname = s.next();
	    
	    System.out.println("Enter the last name:");
	    String Lname = s.next();
	    
	    // Retrieve the list of passenger objects
	    List<employee> employees = database.getEmployeeN(Fname, Lname); 
	   
	    if (!employees.isEmpty()) {
	        System.out.println("Employee details:");
	        for (employee e : employees) {
	            System.out.println("ID: " + e.getId());
	            System.out.println("Full Name: " + e.getFname() + " " + e.getLname());
	            System.out.println("Email: " + e.getEmail());
	            System.out.println("Phone: " + e.getPhone());
	            System.out.println("Job Title: " + e.getTitle());
	            System.out.println("Salary: " + e.getSalary());
	            System.out.println("---------------------------");
	        }
	    } else {
	        System.out.println("No Employees found.");
	    }
	}
public static void getAllEmployees(Database database) throws SQLException {
	ArrayList<employee> employee = database.getAllDataE();
	System.out.println("==================================");
	System.out.println("==================================");
	for(employee e: employee) {
		System.out.println("Id:" +e.getId());
		System.out.println("Full Name:" +e.getFname()+" " +e.getLname() );
		System.out.println("Email:" +e.getEmail());
		System.out.println("Phone number:" +e.getPhone());
		System.out.println("Job Title: " + e.getTitle());
        System.out.println("Salary: " + e.getSalary());
	System.out.println("==================================");
	System.out.println("==================================");
		
	}
		
}
public static void fireEmployee(Database database , Scanner s) throws SQLException {
	int id;
	System.out.println("Enter Employee id:");
	id = s.nextInt();
	
	database.fireEmployee(id);
}

}
