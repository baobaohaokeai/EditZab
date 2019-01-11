package test;

/**
 * 
 * <p>Description: </p>
 * <p>Title: Parent.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年5月26日 上午11:30:59</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public class Parent {
	public static int t = parentStaticMethod2();
	public int t2 = 1;
	
	static {
		System.out.println("父类静态初始化块");
	}

	public Parent() {
		System.out.println("父类构造方法 t2=" + this.t2);//①  
        this.f();//②  
	}
	
	public void f() {  
        System.out.println("父类方法f() t2=" + this.t2);  
    } 
	
	private void f2() {  
        System.out.println("父类方法f2() t2=" + this.t2);  
    } 
	
	{
		System.out.println("父类非静态初始化块");
	}

	public static int parentStaticMethod() {
		System.out.println("父类类的静态方法");
		return 10;
	}

	public static int parentStaticMethod2() {
		System.out.println("父类的静态方法2");
		return 9;
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
//		super.finalize();
		System.out.println("销毁父类");
	}
	
	public static void main(String[] args) {
		System.out.println("---");
		Parent p = new Parent();
		p.f2();
		p.f();
		System.out.println("####@@@@@");
		Parent p2 = new Child();
		p2.f2();
		p2.f();
	}

}
