package com.ning4256.factory;

//定义一个食物接口，他有一个方法可以吃
interface IFood2 {
	public void eat();
}
//定义一个抽象食物类，实现这个食物接口
abstract class Food2 implements IFood {
	public String name;

	public Food2(String name) {
		super();
		this.name = name;
	}
}
//定义具体的食物类
class Milk2 extends Food2 {

	public Milk2(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println(name + "真好喝!!!!");
	}
	
}

class Meat2 extends Food2 {

	public Meat2(String name) {
		super(name);
	}

	@Override
	public void eat() {
		System.out.println(name + "真好吃!!!!");
	}
	
}


//定义个工厂接口，有生产食物的方法
interface FactoryFood2 {
	public Food2 produceFood(String foodName);
}

class Factory2 implements FactoryFood2 {

	@Override
	public Food2 produceFood(String foodName) {
		if (foodName.equalsIgnoreCase("Milk")) {
			return new Milk2("牛奶");
		}else if (foodName.equalsIgnoreCase("Meat")) {
			return new Meat2("牛肉");
		}
		return null;
	}
	
}

public class FactoryMethod2 {
	public static void main(String[] args) {
		Factory2 factory2 = new Factory2();
		factory2.produceFood("milk").eat();
	}
}
