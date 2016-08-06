import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

	int length;
	private static List<String> AVAILABLE_KEYS = new ArrayList<>();
	private static String CURRENT_GUESS_WORD = "";
	private static String CHOSEN_WORD;
	private Random randomGenerator = new Random();
	
	
	public Computer(int length){
		
		this.length = length;
		
		AVAILABLE_KEYS = importKeysFromAnagram();
		
		
	}

	private List<String> importKeysFromAnagram() {
		// TODO Auto-generated method stub
		
		
		return AnagramUtil.getHashMap().keySet();
	}
	
	public String guessWord(){
		
		int indexOfAvailableKeys = randomGenerator.nextInt(AVAILABLE_KEYS.size());
		
		ArrayList<String> list = AnagramUtil.getHashMap().get(AVAILABLE_KEYS.get(index));
		
		int indexOfStringInAnagramMap = randomGenerator.nextInt(list.size());
		String guessWord = list.get(indexOfStringInAnagramMap);
		
		
		
		return guessWord;
		
	}
	private boolean hasRepeatedCharacters(String guessWord) {
		// TODO Auto-generated method stub
		
		for(char c: guessWord.toCharArray()){
			if(guessWord.indexOf(c) != guessWord.lastIndexOf(c))
				return true;
		}
		return false;
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
