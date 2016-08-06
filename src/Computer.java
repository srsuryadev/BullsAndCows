import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.regex.Pattern;

public class Computer {

	int length;
	private static ArrayList<String> AVAILABLE_KEYS = new ArrayList<>();
	private static String CURRENT_GUESS_WORD = "";
	private static String CHOSEN_WORD;
	private Random randomGenerator = new Random();
	private static boolean GAME_WON = false;

	public Computer(int length) {

		this.length = length;

		AVAILABLE_KEYS = importKeysFromAnagram();
		
		selectChosenWord();

	}
	
	public String getChosenWord(){
		
		
		if(GAME_WON)
			return CHOSEN_WORD;
		else
			return "Game not won yet";
	}

	private void selectChosenWord() {
		// TODO Auto-generated method stub
		
		int indexOfAvailableKeys = randomGenerator.nextInt(AVAILABLE_KEYS.size());

		ArrayList<String> list = AnagramUtil.getHashMap().get(AVAILABLE_KEYS.get(indexOfAvailableKeys));

		int indexOfStringInAnagramMap = randomGenerator.nextInt(list.size());
		String guessWord = list.get(indexOfStringInAnagramMap);

		if(hasRepeatedCharacters(guessWord))
			selectChosenWord();
		else
			CHOSEN_WORD = guessWord;
		
		
	}

	private ArrayList<String> importKeysFromAnagram() {
		// TODO Auto-generated method stub

		return (ArrayList<String>) AnagramUtil.getHashMap().keySet();
	}

	public void updateResponse(int match) {

		String str = CURRENT_GUESS_WORD;

		str = sortString(CURRENT_GUESS_WORD);
		if (match == 0) {

			ArrayList<String> combinations = AnagramUtil.combinations(str, 1);

			ArrayList<String> regEx = AnagramUtil.generateRegEx(combinations);

			for (String r : regEx) {

				AVAILABLE_KEYS.removeIf(s -> s.matches(r));
			}

		} else {

			ArrayList<String> combinations = AnagramUtil.combinations(str, match);

			ArrayList<String> regEx = AnagramUtil.generateRegEx(combinations);

			Iterator<String> iterator = AVAILABLE_KEYS.iterator();
			while (iterator.hasNext()) {

				boolean flag = true;

				for (String r : regEx) {
					if (iterator.next().matches(r))
						flag = false;
				}

				if (flag)
					iterator.remove();
			}

		}
	}

	private String sortString(String cURRENT_GUESS_WORD2) {
		// TODO Auto-generated method stub
		char[] chars = cURRENT_GUESS_WORD2.toCharArray();
		Arrays.sort(chars);
		String sorted = new String(chars).toLowerCase();
		return sorted;
	}

	public String guessWord() {

		int indexOfAvailableKeys = randomGenerator.nextInt(AVAILABLE_KEYS.size());

		ArrayList<String> list = AnagramUtil.getHashMap().get(AVAILABLE_KEYS.get(indexOfAvailableKeys));

		int indexOfStringInAnagramMap = randomGenerator.nextInt(list.size());
		String guessWord = list.get(indexOfStringInAnagramMap);

		CURRENT_GUESS_WORD = guessWord;

		return guessWord;

	}

	private boolean hasRepeatedCharacters(String guessWord) {
		// TODO Auto-generated method stub

		for (char c : guessWord.toCharArray()) {
			if (guessWord.indexOf(c) != guessWord.lastIndexOf(c))
				return true;
		}
		return false;
	}

	public int giveResponse(String guessWord) {

		if (CHOSEN_WORD.equalsIgnoreCase(guessWord))
		{
			GAME_WON = true;
			return -1;
		}

		else
			return getNumberOfMatchingLetters(guessWord);

	}

	private int getNumberOfMatchingLetters(String guessWord) {
		// TODO Auto-generated method stub

		int count = 0;

		guessWord = removeRepeatedCharacters(guessWord);
		for (int i = 0; i < guessWord.length(); i++) {
			if (CHOSEN_WORD.contains(String.valueOf(guessWord.charAt(i))))
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
				sb.append((char) i);
			}
		}

		return sb.toString();
	}
}
