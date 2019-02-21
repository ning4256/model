package com.ning4256.factory;
/*
 * 工厂方法模式
 * 
 *	食品工厂：生产食品
 *    1.需要一个食物接口，添加方法eat
 *    2.所有食物的公共抽象类，实现接口
 *    3.创建一堆食物类
 *    4.创建公共的工厂接口，添加方法，生产对象
 *    5.创建工厂类，实现工厂接口
 *
 * */

//1.设计一个接口
interface IFood {
	public void eat();
}

// 2.公共抽象类，实现接口
abstract class Food implements IFood {
	String name;

	public Food(String name) {
		super();
		this.name = name;
	}
	public Food() {
	}
}

// 3.创建食物类
class Milk extends Food {

	public Milk(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println(name + "好喝");
	}
}

class Bread extends Food {

	public Bread(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println(name + "真好吃");
	}

}

class Meat extends Food {

	public Meat(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println(name + "吃了长肉");
	}
}

//4.工厂接口
interface IFactory {
	public Food produceFood(String type);
}
//4.工厂类
class FoodFactory implements IFactory {

	@Override
	public Food produceFood(String type) {
		if(type.equalsIgnoreCase("milk")) {
			return new Milk("特仑苏");
		}else if (type.equalsIgnoreCase("bread")) {
			return new Bread("面包");
		}else if (type.equalsIgnoreCase("meat")) {
			return new Meat("肉类");
		}
		
		return null;
	}
}


public class FactoryMethod {

	public static void main(String[] args) {
//		IFactory factory = new FoodFactory();
//		IFood food = factory.produceFood("milk");
//		System.out.println(food);
		
		FoodFactory factory = new FoodFactory();
		Food meat = factory.produceFood("meat");
		System.out.println(meat);
		
	}
}


