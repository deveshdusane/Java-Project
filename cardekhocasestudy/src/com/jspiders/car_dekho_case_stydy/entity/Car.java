package com.jspiders.car_dekho_case_stydy.entity;

public class Car {
	private int car_id;
	private String name;
	private String model;
	private String brand;
	private String fuel_type;
	private double price;
	
	
	

	public Car(int car_id,String name,String model,String brand,String fuel_type,double price) {
		this.car_id=car_id;
		this.name=name;
		this.model=model;
		this.brand=brand;
		this.fuel_type=fuel_type;
		this.price=price;
	}


	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand)
	{
		this.brand=brand;
	}
	public String getFuel_type() {
		return fuel_type;
	}
	public void setFuel_type(String fuel_type) {
		this.fuel_type = fuel_type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Car Id:"+car_id+",Name ofcar:"+name+",Model od car:"+model+",Brand of Car:"+brand+",Fuel Type of Car:"+fuel_type+",Price of Car:"+price;
	}
	
}
