package com.ning4256.builder;

/*
 * 构建者模式
 * 	简化对象的创建过程，提高程序员的开发效率
 * 
 * 造机器人
 * 	1.头
 * 	2.手
 * 	3.脚
 * 	
 * */
class Head {
	
}

class Footer {
	
}
class Hand {
	
}
class Person {
	Head head;
	Footer footer;
	Hand hand;
	public Person(Head head, Footer footer, Hand hand) {
		super();
		this.head = head;
		this.footer = footer;
		this.hand = hand;
	}
	
}

class PersonBuilder {
	public static Person build() {
		Head head = new Head();
		Footer footer = new Footer();
		Hand hand = new Hand();
		Person person = new Person(head, footer, hand);
		
		return person;
		
	}
}


public class Base {
	public static void main(String[] args) {
		Person person = PersonBuilder.build();
		System.out.println(person);
	}
}
