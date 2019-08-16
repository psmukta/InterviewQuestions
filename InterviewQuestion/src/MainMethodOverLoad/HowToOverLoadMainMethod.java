package MainMethodOverLoad;

public class HowToOverLoadMainMethod {

	public static void main(String string) {
		
		System.out.println("this is main meth--1");
		//main(10);//call from main(int b)
		//main("Selenium");//call from main(string abc)
	}
	public static void main(String[] [] abc) {
		System.out.println("main==2");
	}
	public static void main(int b) {
		System.out.println("main--3");
	}

}
