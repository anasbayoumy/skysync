package connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import skysync.core.employee;
import skysync.core.passenger;
import skysync.core.plane;

public class functions {
    private Statement stmt;

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
    
    //PASSENGERS METHODDSSS FOR DB
    //PASSENGERS METHODDSSS FOR DB
    //PASSENGERS METHODDSSS FOR DB
    //PASSENGERS METHODDSSS FOR DB
    //PASSENGERS METHODDSSS FOR DB

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
    public List<passenger> getPassengerN(String Fname, String Lname) throws SQLException {
        String get = "SELECT `id`, `Fname`, `Lname`, `email`, `phone` FROM `passenger` WHERE `Fname` = ? AND `Lname` = ?";
        PreparedStatement pstmt = stmt.getConnection().prepareStatement(get);
        pstmt.setString(1, Fname);  // Set the first name
        pstmt.setString(2, Lname);  // Set the last name
        
        ResultSet result = pstmt.executeQuery();
        
        List<passenger> passengersList = new ArrayList<>();
        
        // Iterate through the results and add each passenger to the list
        while (result.next()) {
            passenger p = new passenger();
            p.setId(result.getInt("id"));
            p.setFname(result.getString("Fname"));
            p.setLname(result.getString("Lname"));
            p.setEmail(result.getString("email"));
            p.setPhone(result.getString("phone"));
            passengersList.add(p);
        }
        
        return passengersList;  // Return the list of passengers
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
    
    public void deletePassenger(int id) throws SQLException {
    	String check = "SELECT * FROM `passenger` WHERE `id` = "+id+"";
    	ResultSet result = stmt.executeQuery(check);
        
        if (result.next()) {
            // If the passenger exists, proceed to delete
            String delete = "DELETE FROM `passenger` WHERE `id` = ?";
            PreparedStatement deleteStmt = stmt.getConnection().prepareStatement(delete);
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
            System.out.println("Passenger deleted successfully.");
        } else {
            System.out.println("No passenger found with the provided ID.");
        }
    }
    
    //END OF THE PASSENGERS METHODDSSS FOR DB
    //END OF THE PASSENGERS METHODDSSS FOR DB
    //END OF THE PASSENGERS METHODDSSS FOR DB
    //END OF THE PASSENGERS METHODDSSS FOR DB
    
    //==================================================================================================
    
    //EMPLOYEES METHODSSSS FOR DB
    //EMPLOYEES METHODSSSS FOR DB
    //EMPLOYEES METHODSSSS FOR DB
    
    public ArrayList<employee> getAllDataE() throws SQLException {
        String get = "SELECT * FROM `employee`";
        ResultSet result = stmt.executeQuery(get);
        ArrayList<employee> employee = new ArrayList<>();

        while (result.next()) {
            employee e = new employee();
            // Set the ID and other fields
            e.setId(result.getInt("id"));
            e.setFname(result.getString("Fname"));
            e.setLname(result.getString("Lname"));
            e.setEmail(result.getString("email"));
            e.setPhone(result.getString("phone"));
            e.setTitle(result.getString("title"));
            e.setSalary(result.getDouble("salary"));

            //===========================
            employee.add(e);
            //===========================
        }

        return employee; 
    }
    
    public void addEmployee(employee newEmployee) throws SQLException {
        // Retrieve all passengers
        ArrayList<employee> existingEmployee = getAllDataE();

        for (employee e : existingEmployee) {
            if (e.getEmail().equals(newEmployee.getEmail()) || e.getPhone().equals(newEmployee.getPhone())) {
                
                System.out.println("Employee with the same email or phone number already exists.");
                return;
            }
        
        }
        String insert = "INSERT INTO `employee`(`Fname`, `Lname`, `email`, `phone`, `title`, `salary`) VALUES ('"+newEmployee.getFname()+"','"+newEmployee.getLname()+"','"+newEmployee.getEmail()+"','"+newEmployee.getPhone()+"','"+newEmployee.getTitle()+"',"+newEmployee.getSalary()+")";
        stmt.execute(insert);
        System.out.println("Employee added successfully.");
    
    }
    
    public void editEmployee(employee e) throws SQLException {
        String check = "SELECT * FROM `employee` WHERE `id` = " + e.getId();
        ResultSet result = stmt.executeQuery(check);
        
        if (result.next()) {
            // Employee exists, proceed with the update
            String update = "UPDATE `employee` SET `Fname` = '" + e.getFname() + 
                            "', `Lname` = '" + e.getLname() + 
                            "', `email` = '" + e.getEmail() + 
                            "', `phone` = '" + e.getPhone() + 
                            "', `title` = '" + e.getTitle() + 
                            "', `salary` = '" + e.getSalary() + 
                            "' WHERE `id` = " + e.getId();
            stmt.executeUpdate(update);
            System.out.println("+==========++++++====");
            System.out.println("Employee data edited successfully!!");
            System.out.println("+==========++++++====+");
        } else {
            // No employee found with the provided ID
            System.out.println("No employee found with the provided ID.");
        }

        // Close the ResultSet to avoid resource leaks
        result.close();
    }


    	
    
    public employee getEmployee(int id , String phone) throws SQLException {
    	String get = "SELECT `id`, `Fname`, `Lname`, `email`, `phone`, `title`, `salary` FROM `employee` WHERE`id`= "+id+" OR `phone` = "+phone+"";
        ResultSet result = stmt.executeQuery(get);
        employee e = new employee();
        result.next();
        // Set the ID and other fields
        e.setId(result.getInt("id"));
        e.setFname(result.getString("Fname"));
        e.setLname(result.getString("Lname"));
        e.setEmail(result.getString("email"));
        e.setPhone(result.getString("phone"));
        e.setTitle(result.getString("title"));
        e.setSalary(result.getDouble("salary"));
        
		return e; 
    	
    	
    }
    
    public List<employee> getEmployeeN(String Fname, String Lname) throws SQLException {
        String get = "SELECT `id`, `Fname`, `Lname`, `email`, `phone`, `title`, `salary` FROM `employee` WHERE `Fname` = ? AND `Lname` = ?";
        PreparedStatement pstmt = stmt.getConnection().prepareStatement(get);
        pstmt.setString(1, Fname);  // Set the first name
        pstmt.setString(2, Lname);  // Set the last name
        
        ResultSet result = pstmt.executeQuery();
        
        List<employee> employeeList = new ArrayList<>();
        
        // Iterate through the results and add each passenger to the list
        while (result.next()) {
        	employee e = new employee();
            e.setId(result.getInt("id"));
            e.setFname(result.getString("Fname"));
            e.setLname(result.getString("Lname"));
            e.setEmail(result.getString("email"));
            e.setPhone(result.getString("phone"));
            e.setTitle(result.getString("title"));
            e.setSalary(result.getDouble("salary"));
            employeeList.add(e);
        }
        
        return employeeList;  // Return the list of passengers
    }
    public void fireEmployee(int id) throws SQLException {
    	String check = "SELECT * FROM `employee` WHERE `id` = "+id+"";
    	ResultSet result = stmt.executeQuery(check);
        
        if (result.next()) {
            // If the passenger exists, proceed to delete
            String delete = "DELETE FROM `employee` WHERE `id` = ?";
            PreparedStatement deleteStmt = stmt.getConnection().prepareStatement(delete);
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("No employee found with the provided ID.");
        }
    }
    
    //END OF THE EMPLOYEES METHODDSSS FOR DB
    //END OF THE EMPLOYEES METHODDSSS FOR DB
    //END OF THE EMPLOYEES METHODDSSS FOR DB
    //END OF THE EMPLOYEES METHODDSSS FOR DB
    
    //==================================================================================================
    
    //PLANE METHODSSSS FOR DB
    //PLANE METHODSSSS FOR DB
    //PLANE METHODSSSS FOR DB
    
    
    public ArrayList<plane> getAllDataPl() throws SQLException {
        String get = "SELECT * FROM `plane`";
        ResultSet result = stmt.executeQuery(get);
        ArrayList<plane> plane = new ArrayList<>();

        while (result.next()) {
            plane pl = new plane();
            // Set the ID and other fields
            pl.setModel(result.getString("model"));
            pl.setFclass(result.getString("Fclass"));
            pl.setPremium(result.getString("premium"));
            pl.setEconomy(result.getString("economy"));
            //===========================
            plane.add(pl);
            //===========================
        }

        return plane; 
    }
    
    public void addPlane(plane newPlane) throws SQLException {
        // Retrieve all passengers
        ArrayList<plane> existingPlane = getAllDataPl();
        //elmfroood n tcheck en mfeesh tayara bnfs l eh baa m3rfsh
        

       
        String insert = "INSERT INTO `plane`(`model`, `Fclass`, `premium`, `economy`) VALUES ('"+newPlane.getModel()+"','"+newPlane.getFclass()+"','"+newPlane.getPremium()+"','"+newPlane.getEconomy()+"')";
        stmt.execute(insert);
        System.out.println("Plane added successfully.");
    
    }
    public plane getPlane(int id ) throws SQLException {
    	String get = "SELECT `id`, `model`, `Fclass`, `premium`, `economy` FROM `plane` WHERE`id`= "+id+"";
        ResultSet result = stmt.executeQuery(get);
        plane pl = new plane();
        result.next();
        // Set the ID and other fields
        pl.setId(result.getInt("id"));
        pl.setModel(result.getString("model"));
        pl.setFclass(result.getString("Fclass"));
        pl.setPremium(result.getString("premium"));
        pl.setEconomy(result.getString("economy"));
        
		return pl; 
    	
    	
    }
    
    public List<plane> getPlaneM(String model) throws SQLException {
        // SQL query to fetch planes by model using a parameterized query
        String get = "SELECT `id`, `model`, `Fclass`, `premium`, `economy` FROM `plane` WHERE `model` = ?";
        
        // Create the prepared statement to avoid SQL injection
        PreparedStatement pstmt = stmt.getConnection().prepareStatement(get);
        
        // Set the parameter value (the model)
        pstmt.setString(1, model);  
        
        // Execute the query and get the result set
        ResultSet result = pstmt.executeQuery();
        
        // List to hold all the planes that match the given model
        List<plane> planesList = new ArrayList<>();
        
        // Iterate through the results and add each plane to the list
        while (result.next()) {
            plane pl = new plane();
            pl.setId(result.getInt("id"));
            pl.setModel(result.getString("model"));
            pl.setFclass(result.getString("Fclass"));
            pl.setPremium(result.getString("premium"));
            pl.setEconomy(result.getString("economy"));
            planesList.add(pl);
        }
        
        // Close the result set and prepared statement to avoid resource leaks
        result.close();
        pstmt.close();
        
        // Return the list of planes
        return planesList;
    }

        
    public void editPlane(plane pl) throws SQLException {
        String check = "SELECT * FROM `plane` WHERE `id` = " + pl.getId();
        ResultSet result = stmt.executeQuery(check);
        
        if (result.next()) {
            // Employee exists, proceed with the update
            String update = "UPDATE `plane` SET `model` = '" + pl.getModel() + 
                            "', `Fclass` = '" + pl.getFclass() + 
                            "', `premium` = '" + pl.getPremium() + 
                            "', `economy` = '" + pl.getEconomy() + 
                            "' WHERE `id` = " + pl.getId();
            stmt.executeUpdate(update);
            System.out.println("+==========++++++====");
            System.out.println("Plane data edited successfully!!");
            System.out.println("+==========++++++====+");
        } else {
            // No employee found with the provided ID
            System.out.println("No Plane found with the provided ID.");
        }

        // Close the ResultSet to avoid resource leaks
        result.close();
    }
    
    public void deletePlane(int id) throws SQLException {
    	String check = "SELECT * FROM `plane` WHERE `id` = "+id+"";
    	ResultSet result = stmt.executeQuery(check);
        
        if (result.next()) {
            // If the passenger exists, proceed to delete
            String delete = "DELETE FROM `plane` WHERE `id` = ?";
            PreparedStatement deleteStmt = stmt.getConnection().prepareStatement(delete);
            deleteStmt.setInt(1, id);
            deleteStmt.executeUpdate();
            System.out.println("Plane deleted successfully.");
        } else {
            System.out.println("No Plane found with the provided ID.");
        }
    }
}
