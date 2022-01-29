package output;

import java.util.*;

public class WriterRot13Decorator extends WriterDecorator{
	
	public WriterRot13Decorator(DocumentWriter doc)
	{
		super(doc);
	}
	
	public void write(ArrayList<String> contents)
	{
		doc.write(encode(contents));
	}

	private ArrayList<String> encode(ArrayList<String> contents)
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
