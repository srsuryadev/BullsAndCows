import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramUtil {
	
	
	public static String FILE_NAME = "";
	
	public static HashMap<String, ArrayList<String> > hm;
	
	public static HashMap<String, ArrayList<String> > getHash(){
		if(hm!= null) return hm;
		return new HashMap<String, ArrayList<String> >();
	}
	
	
	
	public static String convertToRegEx(String word){
		String regex="";
		for(int i =0;i<word.length();i++){
			regex += "*" + word.charAt(i);
		}
		regex+= "*";
		return regex;
	}
	
	
	public static ArrayList<String> generateRegEx(ArrayList<String> lst){
		ArrayList<String> regexList = new ArrayList<String>();
		for(int i = 0; i<lst.size(); i++){
			regexList.add(convertToRegEx(lst.get(i)));
		}
		return regexList;
	}

	
	
	public static boolean createHashMap(int num) throws FileNotFoundException, IOException{
		HashMap<String, ArrayList<String>> hm = getHash();
		try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if(line.length()==num){
		    		char[] chars = line.toCharArray();
		    	    Arrays.sort(chars);
		    	    String sorted = new String(chars);
		    	    ArrayList<String> lst = new ArrayList<String>();
		    		if(hm.containsKey(sorted)){
		    			lst = hm.get(sorted);
		    		}
		    		lst.add(line);
		    		hm.put(sorted, lst);
		    	}
		    }
		}	
		return true;
		
	}
	
	public static HashMap<String, ArrayList<String> > getHashMap(){
		return getHash();
	}
	
	

}
