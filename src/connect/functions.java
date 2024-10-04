package connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
}
