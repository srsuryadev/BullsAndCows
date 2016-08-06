import java.util.Scanner;

public class Player {
	private int lengthOfWord;
	
	Player(int length){
		lengthOfWord = length;
	}
	
	public String giveGuessWord(){
		String guessWord="";
		Scanner scan = new Scanner(System.in);
		
		while(guessWord.length()!=lengthOfWord){
			System.out.println("Enter Your GuessWord : ");	
			guessWord = scan.next();
		}
		
		return guessWord;
	}
	
	public String giveResponse(){
		String response = "";
		System.out.println("Enter ! if Computer guessed your Secret Word Right or Number of matches : ");
		Scanner scan = new Scanner(System.in);
		
		response = scan.next();
		
		return response;
	}
}
