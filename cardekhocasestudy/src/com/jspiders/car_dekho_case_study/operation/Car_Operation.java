package com.jspiders.car_dekho_case_study.operation;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.List;
import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import com.jspiders.car_dekho_case_study.main.Car_Menu;
import com.jspiders.car_dekho_case_stydy.entity.Car;

public class Car_Operation {
	ArrayList<Car> carList=new ArrayList<Car>();
	public void addCar() {
		Scanner input=new Scanner(System.in);
		System.out.println("How many Cars Do You Want to Add");
		int uinput=input.nextInt();
		if(uinput<1) {
			System.out.println("Please Enter Valid Input");
		}
		Car_Menu cmenu=new Car_Menu();
		
		Scanner input1 =new Scanner(System.in);
		System.out.println("Enter Car-Id:");
		int car_id=input1.nextInt();
		
		System.out.println("Enter Car Name:");
		String name=input1.next();
		
		System.out.println("Enter Car Model");
		String model=input1.next();
		
		System.out.println("Enter Car Brand:");
		String brand=input1.next();
		
		System.out.println("Enter Car Fuel-Type:");
		String fuel_type=input1.next();
		
		System.out.println("Enter Car Price:");
		double price=input1.nextDouble();
		
		Car car= new Car(car_id, name, model, brand, fuel_type, price);
		carList.add(car);
		displayCars();
	}
	
	public void deleteCarDetails() {
		displayCars();
		if (carList.isEmpty()==false) {
			Car car1=null;
			Scanner scanner= new Scanner(System.in);
			System.out.println("Enter car id to delete: ");
			int choice=scanner.nextInt();
			for(Car car:carList) {
				if (car.getCar_id()==choice) {
					car1=car;
				}
			}
			if (car1 !=null) {
				carList.remove(car1);
				System.out.println(car1.getName()+" deleted...");
			}else {
				System.out.println("Invalid choice .....");
			}
		}
	}
	public void displayCars() {
		if (carList.isEmpty()) {
            System.out.println("No cars available.");
        } else {
        	System.out.println("Total car details : " + carList.size());
			System.out.println("ID\t" + "Name\t" + "Brand\t" + "Fuel Type\t" + "Price");
			System.out.println("=======================================================");
			for (Car car : carList) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t" + car.getBrand() + "\t"
						+ car.getFuel_type() + "\t\t" + car.getPrice());
			}
        }

	}
	public void searchByName() {
		if (carList.isEmpty()) {
			System.out.println("No car details found..!!");
			} else {
			System.out.print("Enter car name : ");
			Scanner scanner = new Scanner(System.in);
			String name = scanner.next();
			ArrayList<Car> allCars = new ArrayList<Car>();
			for (Car car : carList) {
			if (car.getName().equalsIgnoreCase(name)) {
					allCars.add(car);
				}
			}
			System.out.println("Total car details : " + allCars.size());
			System.out.println("ID\t" + "Name\t" + "Brand\t" + "Fuel Type\t" + "Price");
			System.out.println("=======================================================");
			for (Car car : allCars) {
			System.out.println(car.getCar_id() + "\t" + car.getName() + "\t" + car.getBrand() + "\t"
						+ car.getFuel_type() + "\t\t" + car.getPrice());
			}
		}
	}
	public void searchByBrand() {
		if (carList.isEmpty()) {
				System.out.println("No car details found..!!");
			} else {
				System.out.print("Enter car brand : ");
				Scanner scanner = new Scanner(System.in);
				String brand = scanner.next();
				ArrayList<Car> allCars = new ArrayList<Car>();
				for (Car car : carList) {
					if (car.getBrand().equalsIgnoreCase(brand)) {
						allCars.add(car);
					}
				}
				System.out.println("Total car details : " + allCars.size());
				System.out.println("ID\t" + "Name\t" + "Brand\t" + "Fuel Type\t" + "Price");
				System.out.println("=======================================================");
				for (Car car : allCars) {
					System.out.println(car.getCar_id() + "\t" + car.getName() + "\t" + car.getBrand() + "\t"
							+ car.getFuel_type() + "\t\t" + car.getPrice());
				}
			}
		}
	public void searchByFuelType() {
		if (carList.isEmpty()) {
			System.out.println("No car details found..!!");
		} else {
			System.out.print("Enter car fuel type : ");
			Scanner scanner = new Scanner(System.in);
			String fuel_type = scanner.next();
			ArrayList<Car> allCars = new ArrayList<Car>();
			for (Car car : carList) {
				if (car.getFuel_type().equalsIgnoreCase(fuel_type)) {
					allCars.add(car);
				}
			}
			System.out.println("Total car details : " + allCars.size());
			System.out.println("ID\t" + "Name\t" + "Brand\t" + "Fuel Type\t" + "Price");
			System.out.println("=======================================================");
			for (Car car : allCars) {
				System.out.println(car.getCar_id() + "\t" + car.getName() + "\t" + car.getBrand() + "\t"
						+ car.getFuel_type() + "\t\t" + car.getPrice());
			}
		}
	}
	public void updateCarDetails() {
		displayCars();
		if (carList.isEmpty() == false) {
			System.out.print("Enter car id to update : ");
			Scanner scanner = new Scanner(System.in);
			int car_id = scanner.nextInt();
			for (Car car : carList) {
				if (car.getCar_id() == car_id) {
					System.out.print("Enter new car name : ");
					car.setName(scanner.next());
					System.out.print("Enter new car brand : ");
					car.setBrand(scanner.next());
					System.out.print("Enter new car fuel type : ");
					car.setFuel_type(scanner.next());
					System.out.print("Enter new car price : ");
					car.setPrice(scanner.nextDouble());
					System.out.println("Car details updated..!!");
				} 
			}
		}
	}
}
