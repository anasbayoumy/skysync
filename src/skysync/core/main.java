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
			System.out.println("2.Exit");
			
			i = s.nextInt();
			switch (i) {
			case 1:
				passenger_controller.newPassenger(database, s);
				break;
			}
			
			
		}while(i!=2);
	}

}
