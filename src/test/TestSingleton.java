package test;

import java.util.ArrayList;
import java.util.Random;

/** 
 * <p>Description: </p>
 * <p>Title: Singleton.java</p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2017年2月13日 下午4:30:25</p> 
 * @author Administrator 
 * @version 1.0 
 * 
 */
public class TestSingleton {
	public static void main(String[] args) {
//		Singleton singleton = Singleton.getSingleton();
//		singleton
		Muti muti = Muti.getSingle();
		for(int i =0;i<10;i++){
			muti.getMsg();
		}
	}
	
	
}

class Singleton {
	private static final Singleton single = new Singleton();
	private Singleton(){
		
	}
	
	public static Singleton getSingleton(){
		return single;
	}
	
}

class Muti{
	private static final int maxCount = 5 ;
	private static ArrayList<Muti> muti = new ArrayList<Muti>();
	static{
		for(int i = 0 ;i<maxCount;i++){
			muti.add(new Muti());
		}
	}
	private Muti(){}
	
	public static Muti getSingle(){
		return muti.get(new Random().nextInt(maxCount));
	}
	
	public static void getMsg(){
		System.out.println(getSingle());
	}
}