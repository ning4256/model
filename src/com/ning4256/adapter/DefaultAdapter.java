package com.ning4256.adapter;

/*
 * 缺省适配器模式
 * 
 * 案例：
 * 	Teacher：
 * 	  教书
 * 	  开家长会
 * 
 * 1.创建一个接口，添加方法
 * 2.所有teacher的抽象类，实现这些方法
 * 3.现有的老师，实现方法，继承抽象老师
 * */

//想要的老师
interface Teacher {
	void teaching();//教书
	void meeting();//开会
}

abstract class AbsTeacher implements Teacher {
	@Override
	public void teaching() {} //缺省实现的代码
	@Override
	public void meeting() {} //缺省实现的代码
}

//3.现有的老师
class ItTeacher extends AbsTeacher {
	@Override
	public void teaching() {
		super.teaching();
		System.out.println("It老师只教写代码");
	}
}




interface Monk {
	void eatFruit();
	void sitting();
	void sleeping();
}

abstract class AllMonk implements Monk {
	@Override
	public void eatFruit() {}
	@Override
	public void sitting() {}
	@Override
	public void sleeping() {}
}

class BigMonk extends AllMonk {
	
}

public class DefaultAdapter {
	public static void main(String[] args) {
		Teacher teacher = new ItTeacher();
		teacher.teaching();
		teacher.meeting();
		
		Monk monk = new BigMonk();
		monk.eatFruit();
		monk.sitting();
		monk.sleeping();
	}
}












