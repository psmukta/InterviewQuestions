package InterviewQuestionPack1;

public class TryAndCatch {

	public static void main(String[] args) {
		try {
		int x=10;
		int y=20;
		int z=y/x;
		
		System.out.println("Result is : "+z);
		
		}catch(ArithmeticException e) {
			System.out.println("You cannot divide by zero");
			
		}
	}

}
