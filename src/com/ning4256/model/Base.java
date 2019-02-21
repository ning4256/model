package com.ning4256.model;

/*
 * 	设计模式：提高开发效率 安全
 * 
 * 	1.单例模式：一个类只能创建出一个对象
 * 		new 构造方法();
 * 	单例模式:构造方法私有化(private)
 * 	提供一个静态方法，用来获取一个当前类的对象
 * 	创建一个私有静态的指向本类对象的引用作为属性
 * 		饱汉模式:对象在需要的时候创建
 * 		饿汗模式:先将对象创建好，使用时直接用
 * 		改进版饱汉模式:线程不安全，多线程的时候
 * 
 * 	2.装饰器模式
 * 
 * */

//单例模式(饱汉模式)
class Full {
	//3.指向本类对象的属性
	private static Full instance = null;
	
	// 1.私有化构造方法
	private Full() {
	}

	// 2.提供一个接口调用这个构造方法
	public static Full getInstance() {
		if(instance == null) {
			instance = new Full();
		}
		return instance;
	}
}
//单例模式(饿汗模式)
class Hungry {
	//3.指向本类对象的属性
	private static Hungry instance = new Hungry();
	//1.私有化构造器
	private Hungry() {
	}
	//2.提供一个接口调用这个构造方法
	public static Hungry getInstance() {
		return instance;
	}
}

public class Base {
	public static void main(String[] args) {
		Full full = Full.getInstance();
		Full full2 = Full.getInstance();
		Hungry hungry = Hungry.getInstance();
		Hungry hungry2 = Hungry.getInstance();
		//利用多线程测试饱汉模式
		for(int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println(full);
				}
			}).start();
		}
	}
}
