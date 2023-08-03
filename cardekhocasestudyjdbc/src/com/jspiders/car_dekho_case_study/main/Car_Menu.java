package com.jspiders.car_dekho_case_study.main;

import java.util.Scanner;

import com.jspiders.car_dekho_case_study.operation.Car_Operation;
//import com.jspiders.car_dekho_case_stydy.entity.Car;

public class Car_Menu {
	public static void main(String[] args) {
	
	carDekhoMenu();
	}

	public static void carDekhoMenu() {
		Car_Operation carop=new Car_Operation();
		Scanner input=new Scanner(System.in);
		boolean loop=true;
		while(loop) {
			System.out.println("=======Menu========\n1.Add Car Details\n2.Search Car Details\n3.Update Car Details\n4.Exit");
			System.out.println("Enter Your Choice");
			int choice=input.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("===========MENU==========\n1. Add Car Details \n2. Remove Car Details \n3. Go Back To Main Menu");
				System.out.print("\nEnter your choice : ");
				Scanner scanner=new Scanner(System.in);
				int choice2 = scanner.nextInt();
				switch (choice2) {
				case 1:
					carop.addCar();
					break;

				case 2:
					carop.deleteCarDetails();
					break;
					
				case 3:
					carDekhoMenu();
					break;
					
				default:
					System.out.println("\nInvalid choice. Try again..!!");
					break;
				}
				break;
			}
			case 2:{
				System.out.println("===========MENU==========\n1. Search Car By Name \n2. Search Car By Brand \n3. Search Car By Fuel Type \n4. Search All Cars \n"
						+ "5. Go Back To Main Menu");
				Scanner scanner= new Scanner(System.in);
				int choice3 = scanner.nextInt();
				switch(choice3) {
				case 1:
					carop.searchByName();
					break;
				case 2:
					carop.searchByBrand();
					break;
				case 3:
					carop.searchByFuelType();
					break;
				case 4:
					carop.displayCars();
					break;
				case 5:
					carDekhoMenu();
					break;
				default:
					System.out.println("\nInvalid choice. Try again..!!");
					break;
				}
			}
				break;
			case 3:{
				carop.updateCar();
			}
				break;
			case 4:{
				System.out.println("Thank You!!!");
				loop=false;
			}
				break;

			default:{
			System.out.println("Invalid Input");
			}
		}
	}
}
}
