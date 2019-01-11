package test;

import org.apache.log4j.chainsaw.Main;


/** 
 * <p>Description: </p>
 * <p>Title: testExtends.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月29日 上午9:18:39</p> 
 * @author wangjb 
 * @version 1.0 
 * 
 */
public class testExtends {
	public static void main(String[] args) {
		C c = new C();
		c.f();
		P p = c;
//		p.
		P p2 = new P();
		System.out.println(p2.b);
	}
}
class P{
	private int a =2;
	protected int b =3;
	private void f(){
		System.out.println("parent.f();");
	}
	protected void f(int i ){
		System.out.println("parent.f(1);");
	}
	public void f2(){
		System.out.println("parent.f2();");
	}
}
class C extends P{
	public void f(){
		System.out.println("child.f();");
	}
	public static void main(String[] args) {
		C c = new C();
		c.f2();
	}
}
