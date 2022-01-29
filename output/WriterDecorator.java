package output;

import java.util.*;

public abstract class WriterDecorator implements DocumentWriter{

	protected DocumentWriter doc;
	
	public WriterDecorator(DocumentWriter doc)
	{
		this.doc = doc;
	}
	
	@Override
	public void write(ArrayList<String> contents)
	{
		doc.write(contents);
	}
}
