package commands;

import model.Document;

public class DocumentController {
	
	protected Document doc;
	private static DocumentController dc = null;
	
	private DocumentController()
	{
		doc = new Document();
	}
	
	public static DocumentController getInstance()
	{
		if(dc == null)
		{
			dc = new DocumentController();
		}
		return dc;
	}
	
	public Document getDocument()
	{
		return doc;
	}
}
