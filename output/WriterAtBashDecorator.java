package output;

import java.util.ArrayList;

public class WriterAtBashDecorator extends WriterDecorator{
	
	public WriterAtBashDecorator(DocumentWriter doc)
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
			char[] chars = line.toCharArray();
			int len = chars.length;
			int i = 0;
			while(i < len) {
				char c = chars[i];
				if(Character.isLetter(c) && Character.isUpperCase(c))
				{
					int dec = ('Z' - c) + 'A';
					chars[i] = (char)dec;
				}
				if(Character.isLetter(c) && Character.isLowerCase(c)) 
				{
					int dec = ('z' - c) + 'a';
					chars[i] = (char)dec;
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
