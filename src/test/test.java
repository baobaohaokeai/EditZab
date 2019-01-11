package test;
/** 
 * <p>Description: </p>
 * <p>Title: test.java</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2017年2月3日 下午4:53:24</p> 
 * @author Administrator 
 * @version 1.0 
 * 
 */
public class test {
	public static void main(String[] args) {
		p1 p = new c3();
		p.read();		
	}
}

abstract class p1{
	public void write(){
		System.out.println("p1");
	}
	
	public abstract void read();
}

abstract class c1 extends p1{
	public void write(){
		System.out.println("c1");
	}

	@Override
	public void read() {
		System.out.println("c1_read");
		testP();
	}
	
	private void testP(){
		this.read2();
	}
	
	
	public abstract void read2();
}
abstract class c2 extends c1{
	public void write(){
		System.out.println("c2");
	}
	
//	public void read(){
//		System.out.println("read2");
//	}

	@Override
	public void read2() {
		System.out.println("c2_read2");
		this.read3();
	}
	
	public abstract void read3();
}
class c3 extends c2{

	public void read3() {
		System.out.println("c3_read3");	
	}
}
