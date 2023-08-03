package com.jspiders.car_dekho_case_study.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import com.jspiders.car_dekho_case_stydy.entity.Car;

public class Car_Operation {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static int result;
	private static FileInputStream file;
	private static Properties properties = new Properties();
	private static String filePath="E:\\WEWAJ\\cardekhocasestudyjdbc\\resources\\db_info.properties";
	private static String query;
	Scanner scanner= new Scanner(System.in);
	
	private static void openConnection() {
		try {
			file=new FileInputStream(filePath);
			properties.load(file);
			
			connection=DriverManager.getConnection(properties.getProperty("dburl"), properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
			if (file != null) {
				file.close();
			}
			if (result != 0) {
				result=0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void addCar() {
		System.out.println("How many cars Do you Want to add: ");
		int choice=scanner.nextInt();
		try {
			openConnection();
			query="insert into car_details "
					+ "values(?,?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			for(int i=1;i<=choice;i++) {
				System.out.println("\nEnter details " +i+" Car Details");
				Car car =new Car();
				
				System.out.println("Enter car Id : ");
				car.setCar_id(scanner.nextInt());
				System.out.println("Enter Car Name: ");
				car.setName(scanner.next());
				System.out.println("Enter Car Model: ");
				car.setModel(scanner.next());
				System.out.println("Enter Car Brand: ");
				car.setBrand(scanner.next());
				System.out.println("Enter Fuel type: ");
				car.setFuel_type(scanner.next());
				System.out.println("Enter Car price: ");
				car.setPrice(scanner.nextDouble());
				
				preparedStatement.setInt(1,car.getCar_id());
				preparedStatement.setString(2, car.getName());
				preparedStatement.setString(3, car.getModel());
				preparedStatement.setString(4, car.getBrand());
				preparedStatement.setString(5, car.getFuel_type());
				preparedStatement.setDouble(6, car.getPrice());
				
				result=preparedStatement.executeUpdate();
				
				System.out.println("Query ok"+result+" row(s) affected");
				displayCars();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
	public void deleteCarDetails() {
		try {
			openConnection();
			query="delete from car_details "
					+ "where carid=?";
			preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter car id to delete: ");
			
			preparedStatement.setInt(1,scanner.nextInt());
			result=preparedStatement.executeUpdate();
			
			System.out.println("Query ok "+result+ "row(s) affected");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	public void displayCars() {
		try {
			openConnection();
			query="select * from car_details ";
			
			preparedStatement=connection.prepareStatement(query);
			
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+"|"
						+resultSet.getString(2)+"|"
						+resultSet.getString(3)+"|"
						+resultSet.getString(4)+"|"
						+resultSet.getString(5)+"|"
						+resultSet.getString(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	public void searchByName() {
		try {
			openConnection();
			query="select * from car_details where name=?";
			preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter the Name: ");
			String name=scanner.next();
			preparedStatement.setString(1, name);
		
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+"|"
						+resultSet.getString(2)+"|"
						+resultSet.getString(3)+"|"
						+resultSet.getString(4)+"|"
						+resultSet.getString(5)+"|"
						+resultSet.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	public void searchByBrand() {
		try {
			openConnection();
			query="select * from car_details where brand=?";
			preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter the Brand: ");
			String brand=scanner.next();
			preparedStatement.setString(1, brand);
		
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+"|"
						+resultSet.getString(2)+"|"
						+resultSet.getString(3)+"|"
						+resultSet.getString(4)+"|"
						+resultSet.getString(5)+"|"
						+resultSet.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	public void searchByFuelType() {
		try {
			openConnection();
			query="select * from car_details where fuel_type=?";
			preparedStatement=connection.prepareStatement(query);
			System.out.println("Enter the Fuel_Type: ");
			String fuel_type=scanner.next();
			preparedStatement.setString(1, fuel_type);
		
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+"|"
						+resultSet.getString(2)+"|"
						+resultSet.getString(3)+"|"
						+resultSet.getString(4)+"|"
						+resultSet.getString(5)+"|"
						+resultSet.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	public void updateCar() {
		try {
			displayCars();
			openConnection();
			
			System.out.println("Which record you want to update: \n1.Upadate by name\n2.Update by brand\n3.Update by fuel_type");
			int choice=scanner.nextInt();
				switch (choice) {
				case 1:{
					System.out.println("Enter car id: ");
					int carid=scanner.nextInt();
					System.out.println("Enter The Name: ");
					String name=scanner.next();
					query="update car_details set name=? where carid=?";
					preparedStatement=connection.prepareStatement(query);
				
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, carid);
				
					result=preparedStatement.executeUpdate();
					System.out.println("Name Update Succefully........");
				}
					break;
				case 2:{
					System.out.println("Enter car id: ");
					int carid=scanner.nextInt();
					System.out.println("Enter The Brand: ");
					String brand=scanner.next();
					query="update car_details set brand=? where carid=?";
					preparedStatement=connection.prepareStatement(query);
				
					preparedStatement.setString(1, brand);
					preparedStatement.setInt(2, carid);
				
					result=preparedStatement.executeUpdate();
					System.out.println("Brand Update Succefully........");
				}
					break;
				case 3:{
			    	System.out.println("Enter car id: ");
			    	int carid=scanner.nextInt();
			    	System.out.println("Enter The Fuel_type: ");
			    	String fuel_type=scanner.next();
			    	query="update car_details set brand=? where carid=?";
			    	preparedStatement=connection.prepareStatement(query);
				
			    	preparedStatement.setString(1, fuel_type);
			    	preparedStatement.setInt(2, carid);
				
			    	result=preparedStatement.executeUpdate();
			    	System.out.println("Fuel_type Update Succefully........");
				}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}
