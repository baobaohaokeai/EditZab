package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * <p>Description: 加载顺序</p>
 * <p>Title: T.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年5月26日 上午10:07:21</p> 
 * @author wangjb 
 * @version 1.0 
 *
 */
public class T  implements Cloneable {
	
	//类属性初始化时虚拟机是不会声明属性的同时赋值的，它会把所有属性和方法全部声明完了
	//再从头按代码顺序赋值。如果你有一定水平的话你会发现在new T("t1")的时候,
	//会执行print("构造快")而print()方法中用到了还没初始化的i和n，并且值都为0。
	//所以属性是全部声明完之后再按照顺序初始化的。

	
	public static int k = 10; //1
	
	public static T t1 = new T();
	public static T t2 = new T();

	public T(){
		System.out.println("构造方法");
	}

	static {
		print("静态块");
		k = 20;
		n = 20;
	}

	public static int n = 10;//3
	public static int i = print("i");//2


	
	public int j = print("j");
	
	{
		print("普通代码快");
	}
	
	public T(String str) {
		System.out.println("j="+j);
		System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
		++n;
		++i;
	}


	public static int print(String str) {
		System.out.println((++k) + ":" + str + "   i=" + i + "   n=" + n);
		++n;
		return ++i;
	}
	
	public static void main(String[] args) {
//		System.out.println("main");
//		T t = new T();
		
		List list = new ArrayList();
	
		Map map = new HashMap();
		map.put(null, null);
		System.out.println(map.get(null));
	}
	
	//类加载过程（静态属性、静态方法声明-----静态属性赋值、静态块）注意先父类后子类
	//实例化过程（普通属性、普通方法声明-----普通属性赋值、普通代码块----构造方法中的代码）也是先父类后子类
	//如果在类加载过程中调用了实例化过程（如new了本类对象），则会暂停类加载过程先执行实例化过程，执行完毕再回到类加载过程
}
