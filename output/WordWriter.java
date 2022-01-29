package output;

import java.util.*;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class WordWriter implements DocumentWriter{

	private String path;
	
	public WordWriter(String path)
	{
		this.path = path;
	}
	
	public void write(ArrayList<String> contents)
	{
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph paragraph = doc.createParagraph();
		XWPFRun run = paragraph.createRun();
		for(String line:contents)
		{
			run.setText(line);
			run.addBreak();
		}
		try{
			FileOutputStream out = new FileOutputStream(new File(path));
			doc.write(out);
			doc.close();
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	
	}
}
