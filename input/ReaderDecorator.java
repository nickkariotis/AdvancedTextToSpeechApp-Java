package input;

import java.util.*;

public abstract class ReaderDecorator implements DocumentReader{
	
	
	protected DocumentReader doc;
	
	public ReaderDecorator(DocumentReader doc)
	{
		this.doc = doc;
	}
	@Override
	public ArrayList<String> read(){
		return doc.read();
	}
}
