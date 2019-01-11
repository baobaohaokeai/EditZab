package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>Description: </p>
 * <p>Title: Child.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年5月26日 上午11:31:07</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public class Child extends Parent {
	public static int t = childStaticMethod();
	public final static int t1 = 10;
	public final static int t22 = 10;
	public static int t3 = 10;
	public static int t4 = 10;
	public int t2 = childStaticMethod();
	
	{
		System.out.println("子类非静态初始化块");
	}

	static {
		System.out.println("子类静态初始化块");
	}

	public Child() {
		System.out.println("子类的构造方法");
	}
	
	public void f() {  
        System.out.println("子类方法f()");  
    } 
	
	public void f2() {  
        System.out.println("子类方法f2()");  
    } 

	public static int childStaticMethod() {
		System.out.println("子类的静态方法");
		return 1000;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("销毁子类");
	}

	public static void main(String[] args) {
//		 Parent p2 = new Parent();
		 System.out.println("-------------------");
		 //父类的静态方法2
		 //父类静态初始化块
		 //父类非静态初始化块
		 //父类构造方法 t2=1
//		 Parent p = new Child();
		 System.out.println("-------------------");
		 //父类的静态方法2
		 //父类静态初始化块
		 //子类的静态方法
		 //子类静态初始化块
		 //父类构造方法 t2=1
		 //子类的构造方法
//		 System.out.println(p.t2);
//		 System.out.println(p2.t2);
//		 System.out.println(Child.t);
//		 System.out.println(Parent.t);
		 
		 List<String> myList = new ArrayList<String>(10);
		 int a = t1 * t22;
		 int b = t3 * t4;
	}
}
