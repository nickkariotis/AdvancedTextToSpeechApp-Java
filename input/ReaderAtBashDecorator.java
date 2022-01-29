package input;

import java.util.ArrayList;

public class ReaderAtBashDecorator extends ReaderDecorator{
	
	public ReaderAtBashDecorator(DocumentReader doc)
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
			char[] chars = line.toCharArray();
			int len = chars.length;
			int i = 0;
			while(i < len) {
				char c = chars[i];
				if(Character.isLetter(c) && Character.isUpperCase(c))
				{
					int dec = ('A' - c) + 'Z';
					chars[i] = (char)dec;
				}
				if(Character.isLetter(c) && Character.isLowerCase(c)) 
				{
					int dec = ('a' - c) + 'z';
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


