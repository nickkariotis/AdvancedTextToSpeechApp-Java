package input;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import java.io.FileNotFoundException;

public class WordReader implements DocumentReader{
	
	private ArrayList<String> contents = new ArrayList<String>();
	private String path;
	
	public WordReader(String path)
	{
		this.path = path;
	}
	
	public ArrayList<String> read()
	{
		try(XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(path)))) {
			List<XWPFParagraph> list = doc.getParagraphs();
			for(XWPFParagraph paragraph :list) {
				String temp = paragraph.getText();
				String[] parts = temp.split("\n");
				for(String line:parts)
				{
					contents.add(line);
				}
		
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
		return contents;
	}
}
