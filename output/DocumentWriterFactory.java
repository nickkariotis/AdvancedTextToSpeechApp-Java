package output;

public class DocumentWriterFactory {

	public DocumentWriterFactory()
	{
		;
	}
	
	public DocumentWriter createWriter(String path,String type,String encoding)
	{
		if(type.equals("docx") && encoding.equals("Default"))
		{
			return new WordWriter(path);
		}
		else if(type.equals("docx") && encoding.equals("Rot13"))
		{
			return new WriterRot13Decorator(new WordWriter(path));
		}
		else if(type.equals("docx") && encoding.equals("Atbash"))
		{
			return new WriterAtBashDecorator(new WordWriter(path));
		}
		else if(type.equals("xlsx") && encoding.equals("Default"))
		{
			return new ExcelWriter(path);
		}
		else if(type.equals("xlsx") && encoding.equals("Rot13"))
		{
			return new WriterRot13Decorator(new ExcelWriter(path));
		}
		else if(type.equals("xlsx") && encoding.equals("Atbash"))
		{
			return new WriterAtBashDecorator(new ExcelWriter(path));
		}
		else {
			return null;
		}
	}
	
}
