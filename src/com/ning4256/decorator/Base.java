package com.ning4256.decorator;
/*
 * 装饰器模式：经常用在不修改原有代码的情况下扩展一个类
 * 
 * 不会修改原有代码
 * 
 * 1.提供一个公共的接口Gift,里面添加相关的方法
 * 2.创建一个真实的礼物类，实现Gift接口
 * 3.创建一个抽象类，该抽象类是所有装饰器的父类，而且该类必须实现Gift接口，添加一个Gift类的属性
 * 4.创建装饰器类，用来装饰要送的礼物
 * 
 * */
interface Gift {
	public void look();
}

class Cup implements Gift {

	@Override
	public void look() {
		System.out.println("啊，这是一个星巴克的杯子！！");
	}
	
}

//装箱类的父类
abstract class Decorator implements Gift {
	public Gift gift; //需要装饰的礼物gift
	public Decorator(Gift gift) {
		this.gift = gift;
	}	
}

//带有心型的盒子
class HeartBox extends Decorator {

	public HeartBox(Gift gift) {
		super(gift);
	}

	@Override
	public void look() {
		//1.执行要扩展的功能代码
		System.out.println("哎，一个心形的盒子！！");
		//2.执行原有的功能代码
		gift.look();
	}
	
}

class OrdinnaryBox extends Decorator {

	public OrdinnaryBox(Gift gift) {
		super(gift);
	}

	@Override
	public void look() {
		//执行要扩展的功能
		System.out.println("哇，普通盒子的礼物");
		//执行原有的功能
		gift.look();
	}
	
}



public class Base {
	public static void main(String[] args) {
//		Cup cup = new Cup();
//		HeartBox heartBox = new HeartBox(cup);
//		//送人了
//		heartBox.look();
//		
//		Cup cup1 = new Cup();
//		OrdinnaryBox ordinnaryBox = new OrdinnaryBox(cup1);
//		//送人了
//		ordinnaryBox.look();
		
		Gift gift = new OrdinnaryBox(new HeartBox(new Cup()));
		gift.look();
		
				
	}
}
