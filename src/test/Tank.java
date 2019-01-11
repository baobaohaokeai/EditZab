package test;
/** 
 * <p>Description: </p>
 * <p>Title: Tank.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年7月6日 下午3:59:09</p> 
 * @author wangjb 
 * @version 1.0 
 * 
 */
public class Tank {
	private boolean isFull = false;
	
	Tank(boolean state){
		this.isFull = state;
	}
	
	void change(boolean state){
		this.isFull = state;
	}
	
	protected void finalize(){
		System.out.println("----");
		if(this.isFull){
			System.out.println("error");
		}
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Tank(true);
		System.gc();
	}
	
}
