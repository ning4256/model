package com.ning4256.adapter;

//对象适配器：将需要添加功能的类作为属性放在适配器里
//我们需要的功能
interface Port2 {
	public void lighter2();

	public void charging2();
}

// 目前所用的功能
class CarLighter2 {
	public void lighter2() {
		System.out.println("通过点烟器，点烟");
	}
}

class PortAdapter2 implements Port2 {
	CarLighter2 lighter2;

	public PortAdapter2(CarLighter2 lighter2) {
		super();
		this.lighter2 = lighter2;
	}

	@Override
	public void lighter2() {
		lighter2.lighter2();
	}

	@Override
	public void charging2() {
		System.out.println("通过适配器充电");
	}

}

public class ObjectAdapter {
	public static void main(String[] args) {
		Port2 port2 = new PortAdapter2(new CarLighter2());
		port2.lighter2();
		port2.charging2();
	}
}
