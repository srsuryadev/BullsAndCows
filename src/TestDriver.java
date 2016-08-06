import java.util.Scanner;


public class TestDriver {
	public static void main(String[] args){
		System.out.println("1 - Easy \n 2 - Medium \n 3 - Hard");	
		Scanner scan = new Scanner(System.in);
		int lengthOfWord = scan.nextInt();
		
		GameSolver solver = new GameSolver(lengthOfWord);
	}
}
