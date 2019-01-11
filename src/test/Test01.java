package test;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;


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
public class Test01 {
	public T t = new T("1"), t1 = new T("2");
	public int a ,b;
	
	public static void  testSb(StringBuffer a ,StringBuffer b){
		a.append(b);
		b = a;
		System.out.println("in_a:"+a);
	}
	public static void  testString(String a ,String b){
		a += b;
		b = a;
		System.out.println("in_a:"+a);
	}
	
	public static void main(String[] args) {
		
//		StringBuffer a  = new StringBuffer("A");
//		StringBuffer b  = new StringBuffer("B");
//		String a1 = "A";
//		String b1 = "B";
//		testSb(a,b);
//		testString(a1,b1);
//		System.out.println(a+","+b);
//		System.out.println(a1+","+b1);
		
//		System.out.println(StringUtils.stripEnd("dsdsuuudaddd", "d"));
		
//		aaa:System.out.println("aaa");
//		bbb:System.out.println("bbb");
//		ccc:System.out.println("ccc");
//		ddd:System.out.println("ddd");
//	
//		String a = "abc";
////		aaa1:
////		for(int j =0;j<3;j++){
////			bbb1:
////			for(int i =0;i<3;i++){
//		aaa:
//				switch (a) {
//				default:
//					System.out.println("default");
//					break;
//				case "1":
//					System.out.println(1);
//					break;
//				case "b":
//					System.out.println("b");
////					break bbb1;
//	//				break;
//				case "ab":
//					System.out.println("ab");
//					break aaa;
//
//	
//				}
////			}
////		}
//		System.out.println("end");
		

	}

}
