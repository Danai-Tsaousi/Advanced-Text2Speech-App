package Output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Input.DocumentReader;

public class AtBashDecorator extends WriteDecorator{
	
	public AtBashDecorator(DocumentWriter rd) {
		super(rd);
		// TODO Auto-generated constructor stub
	}
	

	public List<String> write(String path,List<String> contents){
		return encodeAtb(super.write(path, contents));
	}
	
	static List<String> encodeAtb(List<String> contents) {
		
		StringBuilder strbul=new StringBuilder();
		List<String> list=new ArrayList<>();
		
        for(String str : contents)
        {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(" ");
        }
        String text=strbul.toString();
        
        //encoding AtBash
	    String plaintext = "";
	    text = removeUnwantedChars(text.toLowerCase());
	    
	    for(char c : text.toCharArray()){
	    	if(Character.isLetter(c))
	    	{
	    		plaintext += (char) ('a' + ('z' - c));
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
