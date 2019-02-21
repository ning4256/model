package com.ning4256.adapter;
/*
 * 适配器
 * 	点烟器：点烟
 * 	增加一个充电的功能
 * 1.类适配器模式
 * 	  1.用户需要的接口：点烟器+USB
 * 	  2.本身有的点烟器
 * 2.对象适配器
 * 
 * 3.缺省适配器模式
 * */

//1.客户需要的
interface Port1 {
	// 1.点烟
	public void lighter1();

	// 2.充电
	public void charging1();
}

// 目前现有的
class CarLighter1 {
	public void lighter1() {
		System.out.println("通过点烟器，点烟");
	}
}

// 适配器
class PortAdapter1 extends CarLighter1 implements Port1 {

	@Override
	public void charging1() {
		System.out.println("通过适配器实现充电功能");
	}

}

public class ClassAdapter {
	public static void main(String[] args) {
		Port1 port = new PortAdapter1();
		port.lighter1();
		port.charging1();
	}

}
