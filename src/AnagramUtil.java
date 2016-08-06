import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramUtil {
	
	public static HashMap<String, ArrayList<String> > hm;
	
	public static HashMap<String, ArrayList<String> > getHash(){
		if(hm!= null) return hm;
		return new HashMap<String, ArrayList<String> >();
	}
	
	

	
	
	public static boolean createHashMap(int num) throws FileNotFoundException, IOException{
		
		String file = "";
		HashMap<String, ArrayList<String>> hm = getHash();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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
