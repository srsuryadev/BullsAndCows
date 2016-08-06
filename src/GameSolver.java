import java.util.HashMap;

public class GameSolver {
	
	
	public static int length = 0;
	public GameSolver(int i){
		 this.length = i + 4;
	}
	public String getDistinctWord(String word){
		String answer = "";
		for(int i =0; i< word.length(); i++){
			int control = 0;
			for(int j =0; j<word.length(); j++){
				if(i!=j&&word.charAt(i)==word.charAt(j)){
					control = 1;
				}
			}
			if(control == 0){
				answer = answer + word.charAt(i);
			}
		}
		return answer;
		
	}
	
	public int getResponse(String guessWord, String secretWord){
		
		if(guessWord.equals(secretWord)) return -1; // Wins
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i = 0;i<secretWord.length(); i++){
			hm.put((int)secretWord.charAt(i)-'a',1);
		}
		
		int count = 0;
		String distinctLetterWord = this.getDistinctWord(guessWord) ;
		for(int i =0; i<guessWord.length(); i++){
			if(hm.get(guessWord.charAt(i))==1){
				count++;
			}
		}
		
		return count;
		
	}

}
