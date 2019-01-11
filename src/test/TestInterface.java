package test;

/** 
 * <p>Description: </p>
 * <p>Title: Test01.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: HcSoft</p>
 * <p>Date: 2016年4月29日 上午9:19:58</p> 
 * @author wangjb 
 * @version 1.0 
 * 
 */
public interface TestInterface {
	int i = 0;
	void add();
	void find(int i);
}

class testImpleInterface implements TestInterface{

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("111");
	}

	@Override
	public void find(int i) {
		System.out.println("222");
	}
	
}
