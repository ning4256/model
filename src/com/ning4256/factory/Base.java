package com.ning4256.factory;

/*
 * 工厂模式：
 * 	在实际开发中，经常利用工厂模式来获取自己想要的对象
 * 	很多情况下要自己创建对象很麻烦，这个时候工厂模式提供了更好的解决方案
 * 
 * 三种：
 * 	1.简单工厂
 * 		通过类型判断要创建什么样的东西
 * 	2.工厂方法模式
 * 	3.抽象工厂 
 * 
 * */
//生产汽车
abstract class Vehicle {
	String name;

	public Vehicle(String name) {
		super();
		this.name = name;
	}
}

class Bus extends Vehicle {

	public Bus(String name) {
		super(name);
		System.out.println(name);
	}
}

class Car extends Vehicle {

	public Car(String name) {
		super(name);
		System.out.println(name);
	}
}

class Suv extends Vehicle {

	public Suv(String name) {
		super(name);
	}
}

class SimpleFactory {
	public static final int VEHICLE_BUS = 1;
	public static final int VEHICLE_CAR = 2;
	public static final int VEHICLE_SUV = 3;

	public Vehicle getVehicle(int type) {
		if (type == VEHICLE_BUS) {
			return new Bus("公交车");
		} else if (type == VEHICLE_CAR) {
			return new Car("小汽车");
		} else if (type == VEHICLE_SUV) {
			return new Car("suv");
		}
		return null;
	}
}

public class Base {
	public static void main(String[] args) {
		SimpleFactory factory = new SimpleFactory();
//		Vehicle bus = factory.getVehicle(1);
//		System.out.println(bus);
		Vehicle car = factory.getVehicle(2);
		

	}
}
