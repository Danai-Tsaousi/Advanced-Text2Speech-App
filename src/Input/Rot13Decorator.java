package Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Output.WordWriter;

public class Rot13Decorator extends ReaderDecorator{

	public Rot13Decorator(DocumentReader rd) {
		super(rd);
		// TODO Auto-generated constructor stub
	}
	
	public List<String> read(String path){
		return decodeRot(super.read(path));
	}

	static List<String> decodeRot(List<String> data) {
		System.out.println(data);
		List<String> list=new ArrayList<>();
		
		StringBuilder strbul=new StringBuilder();
		
        for(String str : data)
        {
            strbul.append(str);
            strbul.append(" ");
        }
        String text=strbul.toString();
        
        
		char[] values = text.toCharArray();
        for (int i = 0; i < values.length; i++) {
            char letter = values[i];
            values[i]= mapCharacter(letter);
            
        }
        
        list.add(String.valueOf(values));
        return list;
	}

	private static char mapCharacter(char c) {
		
		if (c >= 'a' && c <= 'z') {
        // Rotate lowercase letters.

			if (c > 'm') {
				c -= 13;
			} else {
				c += 13;
			}
		}else if (c >= 'A' && c <= 'Z') {
        // Rotate uppercase letters.

			if (c > 'M') {
				c -= 13;
			} else {
				c += 13;
			}
		}
	return c;
    
}


}
