package skysync.core;

import java.sql.SQLException;
import java.util.Scanner;

import connect.Database;
import controller.employee_controller;
import controller.passenger_controller;
import controller.plane_controller;

public class main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Database database = new Database();
		Scanner s = new Scanner(System.in);
		
		int i = 0;
		
		do {
			System.out.println("Welcom to SKYSYNC....");
			System.out.println("1.Add passenger");
			System.out.println("2.Find passenger id by name");
			System.out.println("3.Edit passenger");
			System.out.println("4.View all passengers data");
			System.out.println("5.Delete Passenger");
			System.out.println("");
			System.out.println("6.Add employee");
			System.out.println("7.Fidn employee id by name");
			System.out.println("8.Edit employee");
			System.out.println("9.View all employees data");
			System.out.println("10.Fire employee");
			System.out.println("");
			System.out.println("11.Add Plane");
			System.out.println("12.Find plane id by name");
			System.out.println("13.Edit plane");
			System.out.println("14.View all planes data");
			System.out.println("15.Delete Plane");
			
			System.out.println("26.Exit");
			
			i = s.nextInt();
			switch (i) {
			
			//For Passengers
			
			case 1:
				passenger_controller.newPassenger(database, s);
				break;
			case 2:
				passenger_controller.getPassengerN(database, s);
				break;
			case 3:
				passenger_controller.editPassenger(database, s);
				break;
			case 4:
				passenger_controller.getAllPassengers(database);
				break;
			case 5:
				passenger_controller.deletePassenger(database , s);
				break;
				
				//For Employee
				
			case 6:
				employee_controller.newEmployee(database, s);
				break;
			case 7:
				employee_controller.getEmployeeN(database, s);
				break;
			case 8:
				employee_controller.editEmployee(database, s);
				break;
			case 9:
				employee_controller.getAllEmployees(database);
				break;
			case 10:
				employee_controller.fireEmployee(database, s);
				break;
				
				//For Plane
				
			case 11:
				plane_controller.newPlane(database, s);
				break;
			case 12:
				plane_controller.getPlaneM(database, s);
				break;
			case 13:
				plane_controller.editPlane(database, s);
				break;
			case 14:
				plane_controller.getAllPlanes(database);
				break;
			case 15:
				plane_controller.deletePlane(database, s);
				break;
				
				
				
			}
			
			
			
			
		}while(i!=26);
	}

}
