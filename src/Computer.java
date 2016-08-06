import java.util.HashSet;
import java.util.Set;

public class Computer {

	int length;
	private static Set<String> AVAILABLE_KEYS = new HashSet<>();
	private static String CURRENT_GUESS_WORD = "";
	private static String CHOSEN_WORD;
	
	
	public Computer(int length){
		
		this.length = length;
		
		AVAILABLE_KEYS = importKeysFromAnagram();
		
		
	}

	private Set<String> importKeysFromAnagram() {
		// TODO Auto-generated method stub
		
		
		return AnagramUtil.getHashMap().keySet();
	}
	
	
	public int giveResponse(String guessWord){
		
		if(CHOSEN_WORD.equalsIgnoreCase(guessWord))
			return -1;
		
		else
			return getNumberOfMatchingLetters(guessWord);
		
	}

	private int getNumberOfMatchingLetters(String guessWord) {
		// TODO Auto-generated method stub
		
		int count = 0;
		
		guessWord = removeRepeatedCharacters(guessWord);
		for(int i = 0; i<guessWord.length(); i++)
		{
			if(CHOSEN_WORD.contains(String.valueOf(guessWord.charAt(i))))
				count++;
		}
		return count;
	}

	private String removeRepeatedCharacters(String guessWord) {
		int charsCount[] = new int[256];

	    for (int i = 0; i < guessWord.length(); i++) {
	        char ch = guessWord.charAt(i);
	        charsCount[ch]++;
	    }

	    StringBuilder sb = new StringBuilder(charsCount.length);
	    for (int i = 0; i < charsCount.length; i++) {
	        if (charsCount[i] > 0) {
	            sb.append((char)i);
	        }
	    }

	    return sb.toString();
	}
}
