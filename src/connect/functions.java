package connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import skysync.core.passenger;

public class functions {
    private Statement stmt;

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ArrayList<passenger> getAllDataP() throws SQLException {
        String get = "SELECT * FROM `passenger`";
        ResultSet result = stmt.executeQuery(get);
        ArrayList<passenger> passengers = new ArrayList<>();

        while (result.next()) {
            passenger p = new passenger();
            // Set the ID and other fields
            p.setId(result.getInt("id"));
            p.setFname(result.getString("Fname"));
            p.setLname(result.getString("Lname"));
            p.setEmail(result.getString("email"));
            p.setPhone(result.getString("phone"));

            //===========================
            passengers.add(p);
            //===========================
        }

        return passengers; 
    }
    public passenger getPassenger(int id , String phone) throws SQLException {
    	String get = "SELECT `id`, `Fname`, `Lname`, `email`, `phone` FROM `passenger` WHERE`id`= "+id+" OR `phone` = "+phone+"";
        ResultSet result = stmt.executeQuery(get);
        passenger p = new passenger();
        result.next();
        // Set the ID and other fields
        p.setId(result.getInt("id"));
        p.setFname(result.getString("Fname"));
        p.setLname(result.getString("Lname"));
        p.setEmail(result.getString("email"));
        p.setPhone(result.getString("phone"));
        
		return p; 
    	
    	
    }
    public passenger getPassengerN(String Fname, String Lname) throws SQLException {
        String get = "SELECT `id`, `Fname`, `Lname`, `email`, `phone` FROM `passenger` WHERE `Fname` = ? AND `Lname` = ?";
        PreparedStatement pstmt = stmt.getConnection().prepareStatement(get);
        pstmt.setString(1, Fname);  // Set the first name
        pstmt.setString(2, Lname);  // Set the last name
        
        ResultSet result = pstmt.executeQuery();

        if (result.next()) {
            passenger p = new passenger();
            // Set the ID and other fields
            p.setId(result.getInt("id"));
            p.setFname(result.getString("Fname"));
            p.setLname(result.getString("Lname"));
            p.setEmail(result.getString("email"));
            p.setPhone(result.getString("phone"));
            return p;
        } else {
            System.out.println("Passenger not found.");
            return null;
        }
    }

    public void addPassenger(passenger newPassenger) throws SQLException {
        // Retrieve all passengers
        ArrayList<passenger> existingPassengers = getAllDataP();

        for (passenger p : existingPassengers) {
            if (p.getEmail().equals(newPassenger.getEmail()) || p.getPhone().equals(newPassenger.getPhone())) {
                
                System.out.println("Passenger with the same email or phone number already exists.");
                return;
            }
        }

        String insert = "INSERT INTO `passenger`(`Fname`, `Lname`, `email`, `phone`) "
                + "VALUES "
                + "('" + newPassenger.getFname() + "','" + newPassenger.getLname() + "','" + newPassenger.getEmail() + "','" + newPassenger.getPhone() + "')";
        stmt.execute(insert);
        System.out.println("Passenger added successfully.");
    }
    public void editPassenger(passenger p) throws SQLException {
    	String update = "UPDATE `passenger` SET `Fname` = '" + p.getFname() + "', `Lname` = '" + p.getLname() + "', `email` = '" + p.getEmail() + "', `phone` = '" + p.getPhone() + "' WHERE `id` = " + p.getId();
    	stmt.execute(update);
    	System.out.println("+==========++++++====");
    	System.out.println("Passenger data edited successfully!!");
    	System.out.println("+==========++++++====+");
    	
    }
    
    //Functionsssssssss===========

    
}
