package Output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rot13Decorator extends WriteDecorator {
	public Rot13Decorator(DocumentWriter dw) {
		super(dw);
		// TODO Auto-generated constructor stub
	}
	
	public List<String> write(String path,List<String> contents){
		return encodeRot(super.write(path,contents));
	}
	
	public List<String> encodeRot(List<String> contents) {
		List<String> list=new ArrayList<>();
		String text =String.join("", contents);


		char[] v = text.toCharArray();
		
        for (int i = 0; i < v.length; i++) {
            char letter = v[i];
            v[i] = mapCharacter(letter);
        }
        
        list.add(String.valueOf(v));
		return list;

	}
	public char mapCharacter(char c) {
		
		 if (c >= 'a' && c <= 'z') {
             // Rotate lowercase letters.

             if (c > 'm') {
                 c -= 13;
             } else {
                 c += 13;
             }
         } else if (c >= 'A' && c <= 'Z') {
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
