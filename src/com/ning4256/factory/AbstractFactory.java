package com.ning4256.factory;

/*
 * 族：
 * 	USB2.0
 * 	USB3.0
 * 抽象工厂
 *  1.创建USB接口，创建一个方法
 *  2.各个电子设备的抽象类
 *    2.1 U盘的抽象类
 *    2.2 电脑的抽象类
 *  3.创建采用不同族的类对象
 *    3.1 2.0的U盘
 *    3.2 3.0的U盘
 *    3.3 2.0的电脑
 *    3.4 3.0的电脑
 *  4.提供一个公共接口，用来定义工厂的方法
 *  5.工厂类用于创建对象，实现工厂接口
 *  
 * */
//1.公共的接口
interface Usb {
	public void readAndWrite();
}
//2.各个电子设备的抽象类
abstract class UDisk implements Usb {
	
}

abstract class Computer implements Usb {
	
}

//3
class Udisk2 extends UDisk {

	@Override
	public void readAndWrite() {
		System.out.println("通过USB2.0读写的u盘！");
	}
	
}
class Udisk3 extends UDisk {

	@Override
	public void readAndWrite() {
		System.out.println("通过USB3.0读写的U盘！");
	}
	
}
class Computer2 extends Computer {

	@Override
	public void readAndWrite() {
		System.out.println("通过USB2.0读写的电脑");
	}
	
}

class Computer3 extends Computer {

	@Override
	public void readAndWrite() {
		System.out.println("通过USB3.0读写的电脑");
	}
	
}

//公共的工厂接口
interface IUsbFactory {
	double VERSION_2_0 = 2.0;
	double VERSION_3_0 = 3.0;
	
	public UDisk createUdisk(double version);
	public Computer createComputer(double version);
	
}

class UsbFactory implements IUsbFactory {

	@Override
	public UDisk createUdisk(double version) {
		if(version == 2.0) {
			return new Udisk2();
		}else if (version == 3.0) {
			return new Udisk3();
		}
		return null;
	}

	@Override
	public Computer createComputer(double version) {
		if(version == 2.0) {
			return new Computer2();
		}else if (version == 3.0) {
			return new Computer3();
		}
		return null;
	}
	
}



public class AbstractFactory {
	public static void main(String[] args) {
		UsbFactory factory = new UsbFactory();
		Usb usb = factory.createUdisk(IUsbFactory.VERSION_2_0);
		usb.readAndWrite();
	}
}
