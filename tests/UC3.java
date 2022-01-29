package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.jupiter.api.Test;
import model.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
class UC3 {


	private Document test = new Document();
	private String testPath;
	private ArrayList<String> expected = new ArrayList<String>(); //Non encrypted file
	private ArrayList<String> expected2 = new ArrayList<String>(); //AtBash file
	private ArrayList<String> expected3 = new ArrayList<String>(); //Rot13 file
	@Test
	void test() {
		String path = System.getProperty("user.dir").toString();
		
		expected.add("This");
		expected.add("is");
		expected.add("a");
		expected.add("test");
		expected.add("file.");
		
		//Non Encrypted Word
		testPath = path + "\\tests\\test7.docx";
		test.setPath(testPath);
		test.setEncoding("Default");
		test.save(expected);
		ArrayList<String> content1 = new ArrayList<String>();
		try(XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(testPath)))) {
			List<XWPFParagraph> list = doc.getParagraphs();
			for(XWPFParagraph paragraph :list) {
				String temp = paragraph.getText();
				String[] parts = temp.split("\n");
				for(String line:parts)
				{
					content1.add(line);
				}
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		String expected_str = String.join(" ",expected);
		String contentString1 = String.join(" ", content1);
		assertEquals(expected_str,contentString1);
		
		//Non Encrypted Excel
		testPath = path + "\\tests\\test8.xlsx";
		test.setPath(testPath);
		test.setEncoding("Default");
		test.save(expected);
		ArrayList<String> content2 = new ArrayList<String>();
		try(XSSFWorkbook doc = new XSSFWorkbook(Files.newInputStream(Paths.get(testPath)))){
			Sheet datatypeSheet = doc.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            while(iterator.hasNext()) {
            	Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                ArrayList<String> temp = new ArrayList<String>();
                while (cellIterator.hasNext()) {
                	
                	Cell currentCell = cellIterator.next();
                	if(currentCell.getCellType() == CellType.STRING) 
                	{
                		temp.add(currentCell.getStringCellValue());
                	}
                	else if(currentCell.getCellType() == CellType.NUMERIC) 
                	{
                		String str = NumberToTextConverter.toText(currentCell.getNumericCellValue());
                		temp.add(str);
                	}
                }
                String line = String.join(" ",temp);
                content2.add(line);
            }
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		String contentString2 = String.join(" ",content2);
		assertEquals(expected_str,contentString2);
		
		
		expected2.add("Gsrh");
		expected2.add("rh");
		expected2.add("z");
		expected2.add("gvhg");
		expected2.add("urov.");
		//AtBash Word 
		testPath = path + "\\tests\\test9.docx";
		test.setPath(testPath);
		test.setEncoding("Atbash");
		test.save(expected2);
		ArrayList<String> content3 = new ArrayList<String>();
		try(XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(testPath)))) {
			List<XWPFParagraph> list = doc.getParagraphs();
			for(XWPFParagraph paragraph :list) {
				String temp = paragraph.getText();
				String[] parts = temp.split("\n");
				for(String line:parts)
				{
					content3.add(line);
				}
		
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		String expected_str1 = String.join(" ",expected2);
		String contentString3 = String.join(" ",content3);
		assertEquals(expected_str1,contentString3);

		//AtBash Excel
		testPath = path + "\\tests\\test10.xlsx";
		test.setPath(testPath);
		test.setEncoding("Atbash");
		test.save(expected2);
		ArrayList<String> content4 = new ArrayList<String>();
		try(XSSFWorkbook doc = new XSSFWorkbook(Files.newInputStream(Paths.get(testPath)))){
			Sheet datatypeSheet = doc.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            while(iterator.hasNext()) {
            	Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                ArrayList<String> temp = new ArrayList<String>();
                while (cellIterator.hasNext()) {
                	
                	Cell currentCell = cellIterator.next();
                	if(currentCell.getCellType() == CellType.STRING) 
                	{
                		temp.add(currentCell.getStringCellValue());
                	}
                	else if(currentCell.getCellType() == CellType.NUMERIC) 
                	{
                		String str = NumberToTextConverter.toText(currentCell.getNumericCellValue());
                		temp.add(str);
                	}
                }
                String line = String.join(" ",temp);
                content4.add(line);
            }
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		String expected_str2 = String.join(" ",expected2);
		String contentString4 = String.join(" ",content4);
		assertEquals(expected_str2,contentString4);
		
		
		expected3.add("Guvf");
		expected3.add("vf");
		expected3.add("n");
		expected3.add("grfg");
		expected3.add("svyr.");
		
		//Rot 13 Word
		testPath = path + "\\tests\\test11.docx";
		test.setPath(testPath);
		test.setEncoding("Rot13");
		test.save(expected3);
		ArrayList<String> content5 = new ArrayList<String>();
		try(XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(testPath)))) {
			List<XWPFParagraph> list = doc.getParagraphs();
			for(XWPFParagraph paragraph :list) {
				String temp = paragraph.getText();
				String[] parts = temp.split("\n");
				for(String line:parts)
				{
					content5.add(line);
				}
		
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		String contentString5 = String.join(" ",content5);
		String expected_str3 = String.join(" ", expected3);
		assertEquals(expected_str3,contentString5);
		
		
		//Rot 13 Excel
		testPath = path + "\\tests\\test12.xlsx";
		test.setPath(testPath);
		test.setEncoding("Rot13");
		test.save(expected3);
		ArrayList<String> content6 = new ArrayList<String>();
		try(XSSFWorkbook doc = new XSSFWorkbook(Files.newInputStream(Paths.get(testPath)))){
			Sheet datatypeSheet = doc.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            while(iterator.hasNext()) {
            	Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                ArrayList<String> temp = new ArrayList<String>();
                while (cellIterator.hasNext()) {
                	
                	Cell currentCell = cellIterator.next();
                	if(currentCell.getCellType() == CellType.STRING) 
                	{
                		temp.add(currentCell.getStringCellValue());
                	}
                	else if(currentCell.getCellType() == CellType.NUMERIC) 
                	{
                		String str = NumberToTextConverter.toText(currentCell.getNumericCellValue());
                		temp.add(str);
                	}
                }
                String line = String.join(" ",temp);
                content6.add(line);
            }
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		String contentString6 = String.join(" ",content6);
		String expected_str4 = String.join(" ", expected3);
		assertEquals(expected_str4,contentString6);
		
	}

}
