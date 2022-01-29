package input;

public class DocumentReaderFactory {
	
	
	public DocumentReaderFactory() {
		;
	}
	
	public DocumentReader createReader(String path,String type, String encoding)
	{
		if(type.equals("docx") && encoding.equals("Default"))
		{
			return new WordReader(path);
		}
		else if(type.equals("docx") && encoding.equals("Rot13"))
		{
			return new ReaderRot13Decorator(new WordReader(path));
		}
		else if(type.equals("docx") && encoding.equals("Atbash"))
		{
			return new ReaderAtBashDecorator(new WordReader(path));
		}
		else if(type.equals("xlsx") && encoding.equals("Default"))
		{
			return new ExcelReader(path);
		}
		else if(type.equals("xlsx") && encoding.equals("Rot13"))
		{
			return new ReaderRot13Decorator(new ExcelReader(path));
		}
		else if(type.equals("xlsx") && encoding.equals("Atbash"))
		{
			return new ReaderAtBashDecorator(new ExcelReader(path));
		}
		else {
			return null;
		}
	}
}
