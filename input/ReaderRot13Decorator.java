package input;

import java.util.*;

public class ReaderRot13Decorator extends ReaderDecorator{
	
	
	public ReaderRot13Decorator(DocumentReader doc)
	{
		super(doc);
	}
	
	@Override
	public ArrayList<String> read(){
		return decode(doc.read());
	}
	
	private ArrayList<String> decode(ArrayList<String> contents)
	{
		int j = 0;
		for(String line:contents) {
			int i = 0;
			char[] chars = line.toCharArray();
			int len = chars.length;
			while(i < len) {
				char c = chars[i];
				if(c >= 'a' && c <= 'm')
				{
					chars[i] += 13;
				}
		        else if  (c >= 'A' && c <= 'M') 
		        {
		        	chars[i] += 13;
		        }
		        else if  (c >= 'n' && c <= 'z') 
		        {
		        	chars[i] -= 13;
		        }
		        else if  (c >= 'N' && c <= 'Z') 
		        {
		        	chars[i] -= 13;
		        }
				i += 1;
			}
			String lineAgain = String.valueOf(chars);
			contents.set(j, lineAgain);
			j += 1; 
		}
		return contents;
	}
}
