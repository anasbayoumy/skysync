package skysync.core;

import java.sql.SQLException;
import java.util.Scanner;

import connect.Database;
import controller.passenger_controller;

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
			System.out.println("5.Exit");
			
			i = s.nextInt();
			switch (i) {
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
			}
			
				
			
			
		}while(i!=5);
	}

}
