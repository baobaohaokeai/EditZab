package test;


/** 
 * <p>Description: </p>
 * <p>Title: TestEnum.java</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: zjhcSoft</p>
 * <p>Date: 2016年5月12日 下午2:53:04</p> 
 * @author wangjb 
 * @version 1.0 
 * 
 */
public class TestEnum {
	public enum Color{
		RED(1),BLUE(2),BLACK(3);
		private int type;
		private Color(int type){
			this.type = type;
		}
		@Override
		public String toString(){
			return String.valueOf(this.type);
			
		}
	} 
	
	public static void main(String[] args) {
		for(Color c :Color.values()){
			System.out.println(c);
			System.out.println(Color.RED);
		}
		System.out.println(Animal.FISH);
		
	}
}

enum Animal{
	DOG("狗"),
	BIRD("鸟"),
	FISH("<。)#)))≦"),
	CAT("猫");
	String annimal;
	Animal(String annimal){
		this.annimal = annimal;
	}
	@Override
	public String toString() {
		return annimal;
	}
}
