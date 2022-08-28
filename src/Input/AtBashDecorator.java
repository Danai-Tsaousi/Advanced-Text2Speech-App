package Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AtBashDecorator  extends ReaderDecorator{

	public AtBashDecorator(DocumentReader rd) {
		super(rd);
		// TODO Auto-generated constructor stub
	}
	

	public List<String> read(String path){
		return decodeAtb(super.read(path));
	}
	
	static List<String> decodeAtb(List<String> data) {
		
		StringBuilder strbul=new StringBuilder();
		List<String> list=new ArrayList<>();
		
        for(String str : data)
        {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(" ");
        }
        String text=strbul.toString();
        
        //AtBash decoding
        text = removeUnwantedChars(text.toLowerCase());
	    String plaintext = "";
	    for(char c : text.toCharArray()){
	    	if(Character.isLetter(c)){
	    		plaintext += (char) ('z' + ('a' - c));
	        }else{
	        	plaintext += c;
	        }
	    }
	    
	    list.add(plaintext);
	    return list;
	       
	}
		
	private static String removeUnwantedChars(String input)
	{
		String out = "";
	    for(char c : input.toCharArray()){
	    	if(Character.isLetterOrDigit(c)){
	    		out += c;
	    	}else if(Character.isWhitespace(c)) {
	    		out += " ";
	    	}
	    }
	    return out;
	}
}
